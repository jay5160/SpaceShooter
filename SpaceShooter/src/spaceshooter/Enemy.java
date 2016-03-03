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
    private int delay = 50;
    private int speed = 3;
    private int colorCounter = 0;
    private int score = 0;
    private int enemyRadius = 50;
    
    private ArrayList<Circle> balls;
    private ArrayList<Color> color;
    
    private Random randomGenerator = new Random();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    
    public Enemy(){
        balls = new ArrayList<>();
        color = new ArrayList<>();
        //balls.add(new Circle(10, 10, 10));
    }
    
    void move(){
        delay--;
        if(delay < 0){
            delay = 30;
            color.add(getRandomColor());
            balls.add(new Circle(screenSize.getWidth()/2 + 100, randomGenerator.nextInt((int)screenSize.getHeight()/2), enemyRadius)); 
        }
        
        for(Circle c : balls){
            c.setCenterX(c.getCenterX()-speed);
	}
        
        for(int i = balls.size()-1; i >= 0; i--){
            Circle c = balls.get(i);
            if(c.getCenterX() < -c.getRadius()){
		balls.remove(i);
                color.remove(i);
		score++;
            }
        }  
    }
    
    public Color getRandomColor(){
        int colorId = randomGenerator.nextInt(3);
        Color color = Color.RED;
        
        if(colorId == 0){
            color = Color.RED;
        }else if(colorId == 1){
            color = Color.cyan;
        }else if(colorId == 2){
            color = Color.GREEN;
        }
        
        return color;
    }
    
    public ArrayList<Circle> getBalls(){
        return balls;
    }
    
    public ArrayList<Color> getBallColor(){
        return color;
    }
    
    public void shotBallCollision(){
        
    }
    
    public void paint(Graphics2D g) {
        this.move();
        for(Circle c : balls){
            g.setColor(color.get(colorCounter));
            colorCounter++;
            g.fillOval((int)c.getCenterX(), (int)c.getCenterY(), 50, 50);
        }
        g.setColor(Color.WHITE);
        g.drawString("Balls on Screen: " + balls.size(), 100, 20);
        g.drawString("Score: " + score, 100, 40);
        colorCounter = 0;
    }
    
    public int getEnemyRadius(){
        return enemyRadius;
    }
    
    public int getSpeed(){
        return speed;
    }
    
}
