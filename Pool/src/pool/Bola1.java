package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Bola1 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(200, 10, 10)); 
        g.fillOval(x, y, 30, 30);
    }
    public Bola1(int x, int y){
        super(x, y, 10);
    }
}
