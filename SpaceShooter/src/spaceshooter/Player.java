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
    
    private SpaceShooter spaceShooter;
    
    public Player(SpaceShooter spaceShooter){
        this.spaceShooter = spaceShooter;
    }
    
    void move(){
        //where the game logic goes
    }
    
    public void paint(Graphics2D g) {
                this.move();
                //g.setColor(Color.red);
		//g.fillOval(x, y, 30, 30);
                //Where you put the paint objects like these ^
    }
    
    public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			//Where you'd put the logic for key inputs
                }
	}
        
}
