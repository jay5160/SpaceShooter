/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spaceshooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jon
 */
public class SpaceShooter extends javax.swing.JPanel{

    /**
     * @param args the command line arguments
     */
    Enemy enemy = new Enemy();
    Player player = new Player(enemy, 50, 50, 0);
    
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
    
    public void move() {
		player.move();
		enemy.move();
	}
    
    public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		enemy.paint(g2d);
                player.paint(g2d);
	}
    
    public static void main(String[] args) {      
        
        // Made the main method smaller by instaniating the game in the "myJFrame" class - Aaron McFarland
        myJFrame frame = new myJFrame();
        
    }
}