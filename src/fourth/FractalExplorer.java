package fourth;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int width;
    private int heigth;
    private JImageDisplay image;
    private Rectangle2D.Double diapason;
    private JFrame frame;
    private JButton button;
    private Mandelbrot mandelbrot;

    private class resetButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            mandelbrot.getInitialRange(diapason);
            FractalExplorer.this.drawFractal();
        }
    }

    private class mouseClickListener implements MouseListener{
        public void mouseClicked (MouseEvent e){
            int x=e.getX();
            int y=e.getY();
            double xCoord=FractalGenerator.getCoord(diapason.x, diapason.x + diapason.width, image.getWidth(), x);
            double yCoord = FractalGenerator.getCoord(diapason.y, diapason.y + diapason.height, image.getHeight(), y);

            if (e.getButton()==MouseEvent.BUTTON1){
                mandelbrot.recenterAndZoomRange(diapason, xCoord, yCoord, 0.5);
            }
            if (e.getButton()==MouseEvent.BUTTON3){
                mandelbrot.recenterAndZoomRange(diapason, xCoord, yCoord, 1.5);
            }
            FractalExplorer.this.drawFractal();
        }

        public void mouseExited(MouseEvent e) {}

        public void mousePressed(MouseEvent e) {}

        public void mouseReleased(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {

        }
    }

    public FractalExplorer(){
        this(700);
    }

    public FractalExplorer(int size){
        this(size, size);
    }

    FractalExplorer(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        this.diapason = new Rectangle2D.Double();
        this.mandelbrot = new Mandelbrot();
        mandelbrot.getInitialRange(diapason);

    }
    void createAndShowGUI(){
        this.frame=new JFrame("Fractal Explorer");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(this.width, this.heigth);
        this.frame.setResizable(false);

        this.button=new JButton("Reset Display");
        frame.getContentPane().add(BorderLayout.SOUTH, this.button);
        button.addActionListener(new resetButtonListener());

        this.image=new JImageDisplay(this.frame.getWidth(), this.frame.getHeight());
        frame.getContentPane().add(BorderLayout.CENTER, this.image);
        image.addMouseListener(new mouseClickListener());
        frame.setVisible(true);


    }

    private void drawFractal(){
        for (int x=0; x<this.width; x++){
            for (int y=0; y<this.heigth; y++){
                double xCoord = FractalGenerator.getCoord(diapason.x, diapason.x + diapason.width, image.getWidth(), x);
                double yCoord = FractalGenerator.getCoord(diapason.y, diapason.y + diapason.height, image.getHeight(), y);
                int numIters=mandelbrot.numIterations(xCoord, yCoord);
                int rgbColor;
                if (numIters!=-1){
                    float hue = 0.7f + (float) numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }
                else {
                    rgbColor = Color.HSBtoRGB(0, 0, 0);

                }
                image.drawPixel(x,y,new Color(rgbColor));

            }
        }

    }

    public static void main(String[] args) {
        FractalExplorer fractal=new FractalExplorer(500);
        fractal.createAndShowGUI();
        fractal.drawFractal();

    }
}
