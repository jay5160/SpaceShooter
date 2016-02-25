
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jon
 */
public class Player {
    
    //Where the player attributes would go
    private int x;
    private int y;
    private int speed;
    private Color playerColor;
    
    private SpaceShooter spaceShooter;
    
    public Player(SpaceShooter spaceShooter, int x, int y, int speed){
        this.spaceShooter = spaceShooter;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.playerColor = Color.red;
    }
    
    void move(){
        //where the game logic goes
        y += speed;
    }
    
    public void paint(Graphics2D g) {
                this.move();
                g.setColor(playerColor);
		g.fillOval(x, y, 30, 30);
                //Where you put the paint objects like these ^
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            speed = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            speed = 0;
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
                if (e.getKeyCode() == KeyEvent.VK_B){
                    if (playerColor == Color.red){
                        playerColor = Color.blue;
                    }
                    else if (playerColor == Color.blue){
                        playerColor = Color.green;
                    }
                    else if (playerColor == Color.green){
                        playerColor = Color.red;
                    }
                }
	}
        
}
