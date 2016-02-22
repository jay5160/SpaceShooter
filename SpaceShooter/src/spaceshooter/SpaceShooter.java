/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    
    @SuppressWarnings("serial")
    public SpaceShooter() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
                                shot.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
                                shot.keyPressed(e);
			}
		});
		setFocusable(true);
	}
    
    private void move() {
		ball.move();
		racquet.move();
                shot.move();
	}
    
    public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
                shot.paint(g2d);
	}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Shooter");
		SpaceShooter game = new SpaceShooter();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
                        Thread.sleep(8);
		}
            }
    
        }
