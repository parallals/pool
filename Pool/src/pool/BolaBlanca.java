package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 

public class BolaBlanca extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(0, 0, 0)); 
        g.fillOval((int)x, (int)y, 30, 30);
    }
    public BolaBlanca(double x, double y){
        super(x, y, -10);
    }
}