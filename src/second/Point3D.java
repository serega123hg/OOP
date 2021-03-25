package second;
import java.util.Objects;

public class Point3D extends Point2D  {

    /** координата Z **/
    private double zCoord;
    /** Конструктор инициализации **/
    public Point3D ( double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }
    /** Конструктор по умолчанию. **/
    public Point3D () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }

    /** Возвращение координаты Z **/
    public double getZ () {
        return zCoord;
    }

    /** Установка значения координаты Z. **/
    public void setZ ( double val) {
        zCoord = val;
    }

    public boolean isEqual(Object obj){
        // чтобы не сравнивать объект с самим собой
        if (this == obj) return true;
        // сравниваем объекты одного класса, объект не дб null
        if(obj == null || getClass()!=obj.getClass())
            return false;

        Point3D new_point = (Point3D) obj;
        if ( Objects.equals(this.getX(), new_point.getX()) && (Objects.equals(this.getY(), new_point.getY())) && (Objects.equals(this.getZ(), new_point.getZ())))
            return true;

        return false;
    }

    public double distanceTo(Point3D obj) {
        double res=Math.round((Math.sqrt(Math.pow(obj.getX()-this.getX(),2)+Math.pow(obj.getY()-this.getY(),2)+Math.pow(obj.getZ()-this.getZ(),2)))*100.0)/100.0;
        return(res);
    }

}




/*
public class Point3DD {
    // координата X
    private double xCoord;
    // координата Y
    private double yCoord;
    // координата Z
    private double zCoord;
    // Конструктор инициализации
    public Point3D ( double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    // Конструктор по умолчанию.
    public Point3D () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }
    // Возвращение координаты X
    public double getX () {
        return xCoord;
    }
    // Возвращение координаты Y
    public double getY () {
        return yCoord;
    }
    // Возвращение координаты Z
    public double getZ () {
        return zCoord;
    }
    // Установка значения координаты X.
    public void setX ( double val) {
        xCoord = val;
    }
    // Установка значения координаты Y.
    public void setY ( double val) {
        yCoord = val;
    }
    // Установка значения координаты Z.
    public void setZ ( double val) {
        zCoord = val;
    }

    public boolean isEqual(Object obj){
        // чтобы не сравнивать объект с самим собой
        if (this == obj) return true;
        // сравниваем объекты одного класса, объект не дб null
        if(obj == null || getClass()!=obj.getClass())
            return false;

        Point3D new_point = (Point3D) obj;
        if ( Objects.equals(this.getX(), new_point.getX()) && (Objects.equals(this.getY(), new_point.getY())) && (Objects.equals(this.getZ(), new_point.getZ())))
            return true;

        return false;
    }

    public double distanceTo(Point3D obj) {
        double res=Math.round((Math.sqrt(Math.pow(obj.getX()-this.getX(),2)+Math.pow(obj.getY()-this.getY(),2)+Math.pow(obj.getZ()-this.getZ(),2)))*100.0)/100.0;
        return(res);
    }

}
*/


