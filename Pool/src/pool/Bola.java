package pool;

import gui.Ventana;
import java.awt.Graphics;

public abstract class Bola {
    //PROPIEDADES
    protected int x;
    protected int y;
    protected int velocidadX;
    protected int velocidadY;
    protected boolean estado; // Si esta en la mesa o no
    protected final int radio;
    protected int puntaje;
    
    //METODOS
    public abstract void paint(Graphics g, Ventana v);
    
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
    
    public boolean DetectarColision(){
        return true;
    }
    
    public int AnguloColision(){
        return 0;
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
        radio = 10;
        this.puntaje = puntaje;
    }
}
