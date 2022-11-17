package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 

public class Bola7 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(100, 100, 100)); 
        g.fillOval(x, y, 30, 30);
    }
    public Bola7(int x, int y){
        super(x, y, 10);
    }
}