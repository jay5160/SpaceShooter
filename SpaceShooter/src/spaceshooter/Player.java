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
import java.util.Iterator;
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
    private int shotRadius = playerRadius/2;
    private boolean isShooting = false;
    private Enemy enemy;
    private ArrayList<Circle> balls;
    private ArrayList<Circle> playerShots;
    private ArrayList<Color> color;
    private ArrayList<Color> enemyColor;
    private int shotSpeed = 5;
    private int shotDelay = 0;
    private int colorCounter = 0;
    private String test = "";
    private int score = 0;
    private Circle smallCircle;
    private boolean gameOver = false;
    private int finalScore = 0;
    
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
        playerShots = new ArrayList<>();
        color = new ArrayList<>();
        enemyColor = new ArrayList<>();
    }
    
    void move(){
        
        decreaseShotDelay(); //Refactored messy code into a method by Jon Yahr
        playerCollisionWithSides(); //Refactored messy code into a method by Jon Yahr
        playerMove(); //Refactored messy code into a method by Jon Yahr
        refreshEnemyState(); //Refactored messy code into a method by Jon Yahr
        moveAllPlayerShots(); //Refactored messy code into a method by Jon Yahr
        removeOffScreenShots(); //Refactored messy code into a method by Jon Yahr
        collisionWithEnemiesAndShots(); //Refactored messy code into a method by Jon Yahr
        collisionWithEnemiesAndPlayer(); //Refactored messy code into a method by Jon Yahr
        
        for(int i = playerShots.size()-1; i >= 0; i--){
            Circle c = playerShots.get(i);
            
            for(int j = balls.size()-1; j >= 0; j--){
                
                Circle n = balls.get(j);
                if(c.intersects(n.getCenterX()+10, n.getCenterY()-n.getRadius(), 10, n.getRadius()*2) && color.get(i) == enemyColor.get(j)){
                    playerShots.remove(i);
                    color.remove(i);
                    balls.remove(j);
                    enemyColor.remove(j);
                    //enemy.setBalls(balls);
                    //enemy.setEnemyColor(color);
                    score += 100;
                    
                }
            }
        }
        
        for(Circle c: balls){
            c.setRadius(10);
            if(c.intersects(x, y-20, 30, 30) && !gameOver){
                gameOver = true;
                finalScore = score;
                
            }
            c.setRadius(enemy.getEnemyRadius());
        }
    }
    
    public void paint(Graphics2D g) {
                this.move();
                g.setColor(playerColor);
		g.fillOval(x, y, playerRadius, playerRadius);
                
                for(Circle c: playerShots){
                    g.setColor(color.get(colorCounter));
                    colorCounter++;
                    g.drawOval((int)c.getCenterX(), (int)c.getCenterY(), (int)c.getRadius(), (int)c.getRadius());
                }
                colorCounter = 0;
                g.setColor(Color.WHITE);
                g.drawString("Score: " + score, 100, 20);
                //g.drawString("Player Shots: " + playerShots.size(), 100, 60);
                //g.drawString("Enemies from player: " + balls.size(), 100, 80);
                g.drawString(test, 100, 100);
                //g.fillOval(x+14, y+14, 1, 1);
            
                if(gameOver){
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
                    g.setColor(Color.BLACK);
                    g.drawString("Game Over", (int)screenSize.getWidth()/4-30, (int)screenSize.getHeight()/6);
                    g.drawString("Score: " + finalScore, (int)screenSize.getWidth()/4-30, (int)screenSize.getHeight()/6 + 20);
                    g.drawString("Press Space to Restart", (int)screenSize.getWidth()/4-60, (int)screenSize.getHeight()/6 + 60);
                }
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
    public void initialize() // extracted method refactoring by manav mehrotra
    {
                    gameOver = false;
                    score = 0;
                    finalScore = 0;
                    enemy.getBalls().clear();
                    enemy.getBallColor().clear();
                    playerShots.clear();
                    color.clear();
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
                    changePlayerColor(playerColor);
                }
                if (e.getKeyCode() == KeyEvent.VK_W){
                    test = "";
                    isShooting = true;
                    if(shotDelay < 0){
                        shotDelay = 5;
                        //color.add(getRandomColor());
                        playerShots.add(new Circle(x, y+playerRadius/4, shotRadius));
                        color.add(playerColor);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    initialize();
                }
	}
        
        public int getSpeed(){
            return speed;
        }
        
        public void changePlayerColor(Color playerColor){
            if (playerColor == Color.red){
                playerColor = Color.cyan;
            }
            else if (playerColor == Color.cyan){
                playerColor = Color.green;
            }
            else if (playerColor == Color.green){
                playerColor = Color.red;
            }
            this.playerColor = playerColor;
        }
        
        public Color getPlayerColor(){
            return playerColor;
        }
        
        public ArrayList<Circle> getPlayerShots(){
            return playerShots;
        }
        
        public ArrayList<Color> getPlayerColorList(){
            return color;
        }
        
        public int getPlayerRadius(){
            return playerRadius;
        }
        
        public int getShotRadius(){
            return shotRadius;
        }
        
        public int getShotSpeed(){
            return shotSpeed;
        }
        
        public int getScore(){
            return score;
        }
        
        public void setScore(int score){
            this.score = score;
        }
        
        public void removeOffScreenShots(){ //Refactored code by Jon Yahr
            for(int i = playerShots.size()-1; i >= 0; i--){
            Circle c = playerShots.get(i);
                if(c.getCenterX() > screenSize.getWidth()/2+c.getRadius()){
                    playerShots.remove(i);
                    color.remove(i);
                }
            }
        }
        
        public void playerCollisionWithSides(){//Refactored code by Jon Yahr
            if(y < 0 - speed && speed < 0){
                speed = 0;
            }
            if(y > screenSize.getHeight()/2 - playerRadius*2 + speed && speed > 0){
                speed = 0;
            }
        }
        
        public void playerMove(){//Refactored code by Jon Yahr
            y += speed;
        }
        
        public void refreshEnemyState(){//Refactored code by Jon Yahr
            balls = enemy.getBalls();
            enemyColor = enemy.getBallColor();
        }
        
        public void moveAllPlayerShots(){//Refactored code by Jon Yahr
            for(Circle c: playerShots){
                c.setCenterX(c.getCenterX()+shotSpeed);
            }
<<<<<<< HEAD
        }
        
        public void collisionWithEnemiesAndShots(){//Refactored code by Jon Yahr
            for(int i = playerShots.size()-1; i >= 0; i--){
                Circle c = playerShots.get(i);
            
                for(int j = balls.size()-1; j >= 0; j--){
                
                    Circle n = balls.get(j);
                    if(c.intersects(n.getCenterX()+10, n.getCenterY()-n.getRadius(), 10, n.getRadius()*2) && color.get(i) == enemyColor.get(j)){
                        playerShots.remove(i);
                        color.remove(i);
                        balls.remove(j);
                        enemyColor.remove(j);
                        //enemy.setBalls(balls);
                        //enemy.setEnemyColor(color);
                        score += 100;
                    }
                }
            }
        }
        
        public void collisionWithEnemiesAndPlayer(){//Refactored code by Jon Yahr
            for(Circle c: balls){
                c.setRadius(10);
                if(c.intersects(x, y-20, 30, 30) && !gameOver){
                    gameOver = true;
                    finalScore = score;
                }
                c.setRadius(enemy.getEnemyRadius());
            }
        }
        
        public void decreaseShotDelay(){//Refactored code by Jon Yahr
            shotDelay--;
        }
}
