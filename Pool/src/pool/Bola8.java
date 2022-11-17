package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 

public class Bola8 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(250, 250, 250)); 
        g.fillOval((int)x, (int)y, 30, 30);
    }
    public Bola8(double x, double y){
        super(x, y, 10);
    }
}