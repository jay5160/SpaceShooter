/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Jon
 */
public class Enemy {
  
    //where the enemy attributes would go
    private int x;
    private int y;
    private int speed;
    private Color enemyColor;
    
    private SpaceShooter spaceShooter;
    
    public Enemy(SpaceShooter spaceShooter, int speed){
        this.spaceShooter = spaceShooter;
        this.speed = speed;
        this.enemyColor = Color.red;
    }
    
    void move(){
        for(int i = 0; i < 10; i++){
            x -= speed;
        }
    }
    
    public void paint(Graphics2D g) {
                this.move();
                g.setColor(enemyColor);
		g.fillRect(500, 40, 30, 30);
// push test
	}
}
