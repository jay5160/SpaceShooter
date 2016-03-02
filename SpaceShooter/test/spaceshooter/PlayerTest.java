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
import javax.swing.JFrame;
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
public class PlayerTest {
    
    Enemy enemy = new Enemy();
    Player player = new Player(enemy, 50, 50, 0);
    
    public PlayerTest() {
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
     * Test of move method, of class Player.
     */
    @Test
    public void testDefaultSpeed() {
        System.out.println("testDefaultSpeed");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        assertEquals(player.getSpeed(), 5);
    }
    
    @Test
    public void playerFromRedToCyan() {
        System.out.println("playerFromRedToCyan");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        player.changePlayerColor(Color.red);
        assertEquals(player.getPlayerColor(), Color.cyan);
    }
    
    @Test
    public void playerFromCyanToGreen() {
        System.out.println("playerFromCyanToGreen");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        player.changePlayerColor(Color.cyan);
        assertEquals(player.getPlayerColor(), Color.green);
    }
    
    @Test
    public void playerFromGreenToRed() {
        System.out.println("playerFromGreenToRed");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        player.changePlayerColor(Color.green);
        assertEquals(player.getPlayerColor(), Color.red);
    }
    
}
