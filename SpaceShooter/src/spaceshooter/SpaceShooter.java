/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Jon
 */
public class SpaceShooter extends javax.swing.JPanel{

    /**
     * @param args the command line arguments
     */
    
    Player player = new Player(this);
    Enemy enemy = new Enemy(this);
    
    @SuppressWarnings("serial")
    public SpaceShooter() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
			}
		});
		setFocusable(true);
	}
    
    private void move() {
		player.move();
		enemy.move();
	}
    
    public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		player.paint(g2d);
		enemy.paint(g2d);
	}
    
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        JFrame frame = new JFrame("Space Shooter");
	SpaceShooter game = new SpaceShooter();
	frame.add(game);
	frame.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	while (true) {
		game.move();
		game.repaint();
                try {
                    Thread.sleep(2);                 //1000 milliseconds is one second.
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    
}
