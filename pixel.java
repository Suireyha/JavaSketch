import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class pixel extends JButton{

    int pxID;
    boolean painted = false;
    Color activeColor;

    public void setUp(int width, int height){
        
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setSize(width, height);
        this.setBorderPainted(false);
        this.setFocusPainted(true);
        this.setBackground( new Color(255, 255, 255));
        this.activeColor = new Color(0, 0, 0);

        this.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            System.out.println("Pixel ID " + pxID + " clicked!");
            painted = !painted;
            if(painted){
                setBackground(activeColor);
            }
            else{
                setBackground(new Color(255, 255, 255));
            }
         }
            
        });
    }

    //WARNING!!!!! Prefer not to use these two since they don't give pixels and ID
    public pixel(){
        super("");
        setUp(50, 50);
    }
    public pixel(int w, int h){
        super("");
        setUp(w, h);
    }

    //PREFER THESE TWO!!! ID is important
    public pixel(int id){
        super("");
        setUp(50, 50);
        pxID = id;
    }
    public pixel(int w, int h, int id){
        super("");
        setUp(w, h);
        pxID = id;
    }

}
