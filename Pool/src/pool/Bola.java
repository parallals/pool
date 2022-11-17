package pool;

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