/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javafx.scene.shape.Circle;

/**
 *
 * @author Jon
 */
public class Player {
    
    //Where the player attributes would go
    private int x;
    private int y;
    private int speed = 5;
    private Color playerColor;
    private int playerRadius = 30;
    private boolean isShooting = false;
    private Enemy enemy;
    private ArrayList<Circle> balls;
    private ArrayList<Circle> playerShots;
    private int shotDelay = 0;
    
    //private SpaceShooter spaceShooter;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Player(Enemy enemy, int x, int y, int speed){
        //this.spaceShooter = spaceShooter;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.playerColor = Color.red;
        this.enemy = enemy;
        balls = enemy.getBalls();
        playerShots = new ArrayList<Circle>();
    }
    
    void move(){
        //where the game logic goes
        y += speed;
        shotDelay--;
        
        for(Circle c: playerShots){
            c.setCenterX(c.getCenterX()+5);
        }
        
    }
    
    public void paint(Graphics2D g) {
                this.move();
                g.setColor(playerColor);
		g.fillOval(x, y, playerRadius, playerRadius);
                
                for(Circle c: playerShots){
                    g.drawOval((int)c.getCenterX(), (int)c.getCenterY(), (int)c.getRadius(), (int)c.getRadius());
                }
                
                g.setColor(Color.WHITE);
                g.drawString("Player Shots: " + playerShots.size(), 100, 60);
                //g.drawLine(x, y+playerRadius/2, x+(int)screenSize.getWidth(), y+playerRadius/2);
                
                //Where you put the paint objects like these ^
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            speed = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            speed = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            isShooting = false;
        }
    }

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
		//Where you'd put the logic for key inputs
                    speed = -5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
		//Where you'd put the logic for key inputs
                    speed = +5;
                }
                if (e.getKeyCode() == KeyEvent.VK_Q){
                    if (playerColor == Color.red){
                        playerColor = Color.cyan;
                    }
                    else if (playerColor == Color.cyan){
                        playerColor = Color.green;
                    }
                    else if (playerColor == Color.green){
                        playerColor = Color.red;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_W){
                    isShooting = true;
                    if(shotDelay < 0){
                        shotDelay = 5;
                        //color.add(getRandomColor());
                        playerShots.add(new Circle(x, y+playerRadius/4, playerRadius/2));
                    }
                }
	}
        
        public int getSpeed(){
            return speed;
        }
        
}
