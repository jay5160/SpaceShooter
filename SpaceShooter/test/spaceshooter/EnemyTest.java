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
    public void testMove() {
        System.out.println("move");
        Enemy instance = new Enemy();
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalls method, of class Enemy.
     */
    @Test
    public void testGetBalls() {
        System.out.println("getBalls");
        Enemy instance = new Enemy();
        ArrayList<Circle> expResult = null;
        ArrayList<Circle> result = instance.getBalls();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBallColor method, of class Enemy.
     */
    @Test
    public void testGetBallColor() {
        System.out.println("getBallColor");
        Enemy instance = new Enemy();
        ArrayList<Color> expResult = null;
        ArrayList<Color> result = instance.getBallColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shotBallCollision method, of class Enemy.
     */
    @Test
    public void testShotBallCollision() {
        System.out.println("shotBallCollision");
        Enemy instance = new Enemy();
        instance.shotBallCollision();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class Enemy.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics2D g = null;
        Enemy instance = new Enemy();
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnemyRadius method, of class Enemy.
     */
    @Test
    public void testGetEnemyRadius() {
        System.out.println("getEnemyRadius");
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getEnemyRadius();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
