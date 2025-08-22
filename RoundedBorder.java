import java.awt.*;
import javax.swing.border.Border;

public class RoundedBorder implements Border{
    //The Border interface demands we write functionality for isBorderOpaque,getBorderInsets and paintBorder
    public int width;
    boolean hover = false;
    RoundedBorder(int w){
        this.width = w - 10; //I'm adding the -5 because I want the shape to be slightly smaller so that the border will actually fit within the object space
    }
    RoundedBorder(int w, boolean h){ //h is for hovering
        this.width = w - 10;
        hover = h;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
        Graphics2D g2d = (Graphics2D) g; //Cast the Graphics object (g) into a Graphics2D object (I need this for setStroke();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Adds anti aliasing so that the shape is drawn smoothly :)
        g2d.setStroke(new BasicStroke(3));
        if(hover){
            g2d.setStroke(new BasicStroke(5));
        }
        g2d.drawRoundRect(1, 1, this.width, this.width, this.width, this.width);
    }

    @Override
    public Insets getBorderInsets(Component c){
        return new Insets(8,10,12,17); //This is like css padding, this says to pad 8px from the top and 5px from the right
    }

    @Override
    public boolean isBorderOpaque(){
        return true;
    }
    

}