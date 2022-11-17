package pool;

import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Bola {
    //PROPIEDADES
    protected double x;
    protected double y;
    protected double velocidadX;
    protected double velocidadY;
    protected boolean estado; // Si esta en la mesa o en una tronera
    protected int puntaje;
    
    //METODOS
    public abstract  void paint(Graphics g, JPanel panel);
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public double getVelocidadX(){
        return velocidadX;
    }
    
    public double getVelocidadY(){
        return velocidadY;
    }
    
    public void setVelocidadX(double velocidadX){
        this.velocidadX = velocidadX;
    }
    
    public void setVelocidadY(double velocidadY){
        this.velocidadY = velocidadY;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
        
    public int getPuntaje(){
        return puntaje;
    }
    
    public Bola(double x, double y, int puntaje){
        this.x = x;
        this.y = y;
        velocidadX = 0;
        velocidadY = 0;
        estado = true; // Si esta en la mesa o no
        this.puntaje = puntaje;
    }
}