/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

/**
 *
 * @author qnh29
 */
import javax.swing.JFrame;
public class myJFrame extends JFrame {
    myJFrame()
    {
        super("Space Shooter");
        myJPanel mjp = new myJPanel() {};
         getContentPane().add(mjp,"Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (600, 600);
        setVisible(true);
        
        
    
}
    
}
