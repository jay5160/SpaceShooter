/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Graphics2D;

/**
 *
 * @author Jon
 */
public class Enemy {
  
    //where the enemy attributes would go
    
    private SpaceShooter spaceShooter;
    
    public Enemy(SpaceShooter spaceShooter){
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
}
