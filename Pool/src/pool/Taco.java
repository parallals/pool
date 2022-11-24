package pool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;

public class Taco {
    //PROPIEDADES
    protected int x;
    protected int y;
    protected Polygon p;
    
    //METODOS
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics g, JPanel panel){
        g.setColor(Color.yellow);
        //g.fillRect(x, y, 10, 150);
        p = new Polygon();
        p.addPoint(x,y);p.addPoint(x+10,y);p.addPoint(x+10,y+150);p.addPoint(x,y+150);
        g.drawPolygon(p);
        g.fillPolygon(p);
        
        
    }
    public Taco(int x,int y){
        this.x = x;
        this.y = y;
    }
}
