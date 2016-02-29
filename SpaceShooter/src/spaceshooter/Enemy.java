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
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.shape.Circle;

/**
 *
 * @author Jon
 */
public class Enemy{
  
    //where the enemy attributes would go
    private int x;
    private int y;
    private int delay = 30;
    private int speed = 7;
    private int colorCounter = 0;
    
    private ArrayList<Circle> balls;
    private ArrayList<Color> color;
    
    private Random randomGenerator = new Random();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    private SpaceShooter spaceShooter;
    
    public Enemy(SpaceShooter spaceShooter){
        this.spaceShooter = spaceShooter;
        balls = new ArrayList<Circle>();
        color = new ArrayList<Color>();
        //balls.add(new Circle(10, 10, 10));
    }
    
    void move(){
        delay--;
        if(delay < 0){
            delay = 90;
            color.add(getRandomColor());
            balls.add(new Circle(screenSize.getWidth(), randomGenerator.nextInt((int)screenSize.getHeight()/2-150)-50, 200)); 
        }
        
        for(Circle c : balls){
            c.setCenterX(c.getCenterX()-speed);
	}
        
    }
    
    private Color getRandomColor(){
        int colorId = randomGenerator.nextInt(3);
        Color color = Color.RED;
        
        if(colorId == 0){
            color = Color.RED;
        }else if(colorId == 1){
            color = Color.BLUE;
        }else if(colorId == 2){
            color = Color.GREEN;
        }
        
        return color;
    }
    
    public void paint(Graphics2D g) {
        this.move();
        for(Circle c : balls){
            g.setColor(color.get(colorCounter));
            colorCounter++;
            g.fillOval((int)c.getCenterX(), (int)c.getCenterY(), 200, 200);
        }
        colorCounter = 0;      
    }
}
