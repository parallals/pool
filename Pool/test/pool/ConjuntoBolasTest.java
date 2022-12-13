/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pool;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jelve
 */
public class ConjuntoBolasTest {
    private ConjuntoBolas cb;
    
    public ConjuntoBolasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ConjuntoJugadores cj = new ConjuntoJugadores();
        cb = new ConjuntoBolas(new MesaBillar(cj),cj);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getcantidadBolas method, of class ConjuntoBolas.
     */
    @Test
    public void testDetectarColision(){
        Bola b1 = new Bola(1,1,1,2);
        Bola b2 = new Bola(10,10,1,2);
        assertTrue(cb.DetectarColision(b1, b2));
    }
}
