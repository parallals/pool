package pool;

import gui.Ventana;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Bola {
    //PROPIEDADES
    protected int x;
    protected int y;
    protected int velocidadX;
    protected int velocidadY;
    protected boolean estado; // Si esta en la mesa o en una tronera
    protected final int radio;
    protected int puntaje;
    
    //METODOS
    public abstract void paint(Graphics g, JPanel panel);
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void ColisionSimple(){
        
    }
    
    public boolean DetectarColision(){
        return true;
    }
    
    public void AnguloColision(){
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    
    public Bola(int x, int y, int puntaje){
        this.x = x;
        this.y = y;
        velocidadX = 0;
        velocidadY = 0;
        estado = true; // Si esta en la mesa o no
        radio = 15;
        this.puntaje = puntaje;
    }
}



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

public class Bola2 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(10, 200, 10)); 
        g.fillOval(x, y, 30, 30);
    }
    public Bola2(int x, int y){
        super(x, y, 10);
    }
}
    
public class Bola3 extends Bola{
    //METODOS
    @Override
    public void paint(Graphics g, JPanel panel){
        g.setColor(new Color(10, 10, 200)); 
        g.fillOval(x, y, 30, 30);
    }
    public Bola3(int x, int y){
        super(x, y, 10);
    }
}