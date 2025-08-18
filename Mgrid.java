import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mgrid{
    public static void main(String[] args) throws Exception{
        int pxCount = 0;
        Color inFocus = new Color(52, 53, 54);
        Color noFocus = new Color(47, 48, 49);
        GridBagConstraints flex = new GridBagConstraints();
        pixel[][] grid = new pixel[20][20];
        int length = grid.length;


        JPanel panel = new JPanel(new GridBagLayout());
        panel.setSize(500, 500);
        //panel.add(new btn(50, 50), new GridBagConstraints());

        for(int x = 0; x < length; x++){
            flex.gridy++;
            for(int y = 0; y < length; y++){
                grid[x][y] = new pixel(25, 25, pxCount);
                panel.add(grid[x][y], flex); //Note, you HAVE to use the GridBagConstraints type here otherwise it overloads to something else >:()
                pxCount++;
            }
            
        }

        panel.setOpaque(true);
        panel.setFocusable(true);

        JFrame win = new JFrame("MGrid");
        win.setBounds(200, 200, 800, 800); //Place a 800x800 window at 200,200 (200 px down and right from top left)
        win.setContentPane(panel);
        System.out.println("Hello world");
        win.setVisible(true);

        //Close the window when user closes the window :fire:
        //frame.addWindowListener is very similar to add event listener in js
        win.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        panel.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e){
                System.out.println("Lost focus... :(");
                win.getContentPane().setBackground(noFocus);
                panel.setBackground(noFocus);
            }
        });

        panel.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                System.out.println("Welcome back!! :)");
                win.getContentPane().setBackground(inFocus);
                panel.setBackground(inFocus);
            }
        });

        
        
    }
}
    
    
    