
package pool;

import java.awt.Graphics;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pool.Bola;
import pool.Bola;
import static org.junit.Assert.*;

/**
 *
 * @author jelve
 */
public class BolaTest {
    private Bola bola;
    
    public BolaTest() {
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
     * Test of getSerie method, of class Bola.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        bola = new Bola(1,1,15,13);
        int expResult = 13;
        int result = bola.getSerie();
        assertEquals(expResult, result);
    }

}
