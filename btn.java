import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class btn extends JButton{
    private int width;
    boolean selected = false;
    int btnID;
    Color selectBlue = new Color(0, 138, 202);
    Color hoverBlue = new Color(0, 138, 202, 91);
    Color lightGrey = new Color(126, 126, 126);
    Color white = new Color(220, 220, 220);

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

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                //Mouse is hovering button
                changeHoverColour(true, selected);
            }
            @Override
            public void mouseExited(MouseEvent e){
                //Mouse has left button
                changeHoverColour(false, selected);
            }
        });

    }

    public void changeHoverColour(boolean hover, boolean selected){
        if(hover){
            this.setForeground(hoverBlue);
        }
        else{
            changeSelectColour(selected);
        }

    }

    public void changeSelectColour(boolean selected){
        if(selected){
            this.setForeground(selectBlue);
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
        setUp(75, 75, false);
    }
    

}