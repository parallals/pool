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
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void TestDetectarColisionB(){
        ConjuntoBolas cb = new ConjuntoBolas(new MesaBillar());
        Bola b1 = new Bola(0,3,23,13);
        Bola b2 = new Bola(0,34,13,23);
        assertTrue(cb.DetectarColision(b1,b2));
    }

}