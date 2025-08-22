import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class btn extends JButton{
    private int width;
    boolean selected = false;
    int btnID;
    Color selectBlue = new Color(0, 138, 202);
    Color hoverBlue = new Color(0, 140, 212, 170);
    Color lightGrey = new Color(126, 126, 126);
    Color white = new Color(220, 220, 220);
    RoundedBorder circleBorder;

    public void transparentSetup(){
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setFocusPainted(false);
        this.setBorder(circleBorder);
        this.setForeground(lightGrey);
        this.setVerticalTextPosition(AbstractButton.TOP);
        this.setFont(new Font("Ubuntu Sans", Font.BOLD, 15));
    }

    public void setUp(int width, int height, boolean isTransparent){
        this.width = width;
        circleBorder = new RoundedBorder(width);
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
            circleBorder.hover = true;
            //this.setBorder(circleBorder);
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



    public btn(boolean t){
        super("");
        setUp(75, 75, t);

    }
    public btn(boolean t, String name, int id){
        super(name);
        btnID = id;
        setUp(75, 75, t);

    }

    /* //These more or less won't ever get used. I can reimplement them properly later if I want to make dynamic sized buttons
    public btn(int w, int h, boolean t){
        super("");
        setUp(w, h, t);
    }
    public btn(int w, int h){
        super("");
        setUp(w, h, false);
    }
    public btn(){
        super("");
        setUp(75, 75, false);
    }
    */

}