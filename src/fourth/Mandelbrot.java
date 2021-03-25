package fourth;
import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS=2000;

    public Mandelbrot(){}

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x=-2;
        range.y=-1.5;
        range.width=3;
        range.height=3;

    }

    @Override
    public int numIterations(double x, double y) {
        int iter=0;

        Complex com=new Complex();
        Complex newcom;
        Complex c=new Complex(x, y);
        while ((iter<MAX_ITERATIONS)&&(com.modul()<4)){
            iter+=1;
            newcom=com.Pow().Plus(c);
            com=newcom;

        }
        if (iter==MAX_ITERATIONS)
            return -1;
        else
            return iter;

    }

}
