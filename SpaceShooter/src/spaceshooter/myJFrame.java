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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class myJFrame extends JFrame {
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    SpaceShooter game = new SpaceShooter();
    final int TimeDelay = 20;
    
    myJFrame()
    {
        // Instantiated the game here - Aaron McFarland
        this.add(game);
        game.setBackground(Color.black);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
        setVisible(true);
        
        	while (true) {
		game.move();
		game.repaint();
                
                try {
                    Thread.sleep(TimeDelay);
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    
}
