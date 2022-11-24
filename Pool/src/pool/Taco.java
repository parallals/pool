package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Taco {
    //PROPIEDADES
    protected int x;
    protected int y;
    
    //METODOS
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics g, JPanel panel){
        g.setColor(Color.yellow);
        g.fillRect(x, y, 10, 150);
    }
    public Taco(int x,int y){
        this.x = x;
        this.y = y;
    }
}
