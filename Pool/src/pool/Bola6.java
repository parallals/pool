package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 

public class Bola6 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(200, 200, 10)); 
        g.fillOval((int)x, (int)y, 30, 30);
    }
    public Bola6(double x, double y){
        super(x, y, 10);
    }
}