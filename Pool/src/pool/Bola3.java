package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

    
public class Bola3 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(10, 10, 200)); 
        g.fillOval((int)x, (int)y, 30, 30);
    }
    public Bola3(double x, double y){
        super(x, y, 10);
    }
}