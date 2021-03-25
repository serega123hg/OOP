package second;
import java.util.Scanner;

public class Lab2 {
    public static double computeArea(Point3D obj1, Point3D obj2, Point3D obj3) {
        double a = obj2.distanceTo(obj1);
        double b = obj3.distanceTo(obj2);
        double c = obj1.distanceTo(obj3);
        System.out.println("Сторона а " + a);
        System.out.println("Сторона b " + b);
        System.out.println("Сторона c " + c);
        // расчет по формуле Герона
        double p = (a + b + c) / 2;
        double S = Math.round((Math.sqrt(p * (p - a) * (p - b) * (p - c))) * 100.00) / 100.00;
        return S;
    }
    public static void main(String[] args) {
        // вводим координаты первой точки
        Scanner s=new Scanner(System.in);
        System.out.println("Введите координаты первой точки:" );
        double x1=s.nextDouble();
        //System.out.println("Y1:" );
        double y1=s.nextDouble();
        //System.out.println("Z1:" );
        double z1=s.nextDouble();

        // вводим координаты второй точки
        System.out.println("Введите координаты второй точки:" );
        double x2=s.nextDouble();
       // System.out.println("Y2:" );
        double y2=s.nextDouble();
        //System.out.println("Z2:" );
        double z2=s.nextDouble();
        // вводим координаты третьей точки
        System.out.println("Введите координаты третьей точки:" );
        double x3=s.nextDouble();
        //System.out.println("Y3:" );
        double y3=s.nextDouble();
        //System.out.println("Z3:" );
        double z3=s.nextDouble();

        // создаем объекты
        Point3D Point1=new Point3D(x1,y1,z1);
        Point3D Point2=new Point3D(x2,y2,z2);
        Point3D Point3=new Point3D(x3,y3,z3);


        System.out.println(Point1.getX()+" "+ Point1.getY()+ " "+Point1.getZ());
        System.out.println(Point2.getX()+" "+ Point2.getY()+ " "+Point2.getZ());
        System.out.println(Point3.getX()+" "+ Point3.getY()+ " "+Point3.getZ());


        // точки не должны иметь одинаковые координаты
        if((Point1.isEqual(Point2))||(Point2.isEqual(Point3))||(Point1.isEqual(Point3)))

            System.out.println("Найдены равные координаты");

        //else if (Point1.equals(Point2)&&Point2.equals(Point3)&&Point3.equals(Point1))
        else
            System.out.println("Площадь треугольника: "+computeArea(Point1, Point2, Point3));

    }

}

