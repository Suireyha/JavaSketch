import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class btn extends JButton{
    private int width;
    boolean selected = false;
    int btnID;
    Color lightGrey = new Color(126, 126, 126);
    Color white = new Color(220, 220, 220);
    //Border lightGrey = BorderFactory.createLineBorder(new Color(126, 126, 126), 3); // Pastel blue and a thickness of 2 pixels
    //Border white = BorderFactory.createLineBorder(new Color(220, 220, 220), 3);
    //RoundedBorder rb = new RoundedBorder(width);

    public void transparentSetup(){
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setFocusPainted(true);
        this.setBorder(new RoundedBorder(width));
        this.setForeground(lightGrey);
    }

    public void setUp(int width, int height, boolean isTransparent){
        this.width = width;
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setSize(width, height);

        if(isTransparent){
            transparentSetup();
        }

        this.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            System.out.println("Clicked!");
            selected = !selected;
            changeSelectColour(selected);
         }
            
        });
    }

    public void changeSelectColour(boolean selected){
        if(selected){
            this.setForeground(white);
        }
        else{
            this.setForeground(lightGrey);
        }
    }

    
    public btn(int w, int h, boolean t){
        super("");
        setUp(w, h, t);
    }
    public btn(int w, int h){
        super("");
        setUp(w, h, false);
    }
    public btn(boolean t){
        super("");
        setUp(75, 75, t);

    }
    public btn(){
        super("");
        setUp(50, 50, false);
    }

}