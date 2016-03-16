
package spaceshooter;

import java.awt.Color; 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Test
    public void EnemyDelayIsNotNegative() {
        System.out.println("EnemyDelayIsNotNegative");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        boolean notNegative = true;
        if(0 > enemy.getDelay()){
            notNegative = false;
        }
        assertEquals(notNegative, true);
    }
    
    @Test
    public void EnemyRadiusIsLargerThanShotRadius() {
        System.out.println("EnemyRadiusIsLargerThanShotRadius");
        Enemy enemy = new Enemy();
        Player player = new Player(enemy, 50, 50, 5);
        boolean enemyIsLarger = false;
        if(player.getShotRadius() < enemy.getEnemyRadius()){
            enemyIsLarger = true;
        }
        assertEquals(enemyIsLarger, true);
    }
    
}
