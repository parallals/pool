package pool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;

public class Taco {
    //PROPIEDADES
    private int x;
    private int y;
    private Polygon p;
    private float cos;
    private float sen;
    
    //METODOS
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setCosSen(float cos, float sen){
        this.cos = cos;
        this.sen = sen;
    }
    
    public void paint(Graphics g, JPanel panel){
        g.setColor(Color.yellow);
        p = new Polygon();
        p.addPoint((int)(x+30*cos+2*sen),(int)(y-30*sen+2*cos)); //Parte cercana a la bola
        p.addPoint((int)(x+30*cos-2*sen),(int)(y-30*sen-2*cos));
        p.addPoint((int)(x+400*cos-5*sen), (int)(y-400*sen-5*cos)); // Parte lejana a la bola 
        p.addPoint((int)(x+400*cos+5*sen), (int)(y-400*sen+5*cos));
        g.drawPolygon(p);
        g.fillPolygon(p);
        
        
    }
    public Taco(int x,int y){
        this.x = x;
        this.y = y;
    }
}
