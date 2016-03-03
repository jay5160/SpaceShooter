/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceshooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javafx.scene.shape.Circle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jon
 */
public class EnemyTest {
    
    public EnemyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Enemy.
     */
    @Test
    public void BallListSizeAndColorListSize() {
        System.out.println("BallListSizeAndColorListSize");
        Enemy enemy = new Enemy();
        int colorSize = enemy.getBallColor().size();
        int ballsSize = enemy.getBalls().size();
        assertEquals(colorSize, ballsSize);
    }
    
    @Test
    public void getRandomColorTest() {
        System.out.println("getRandomColorTest");
        Enemy enemy = new Enemy();
        Color color = enemy.getRandomColor();
        boolean validColor = false;
        if(color == Color.CYAN || color == Color.RED || color == Color.GREEN){
            validColor = true;
        }
        assertEquals(validColor, true);
    }
    
    @Test
    public void EnemySpeedLessThanShotSpeed() {
        System.out.println("EnemySpeedLessThanShotSpeed");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        boolean EnemySpeedIsLess = false;
        if(enemy.getSpeed() < player.getShotSpeed()){
            EnemySpeedIsLess = true;
        }
        assertEquals(EnemySpeedIsLess, true);
    }
    
}
