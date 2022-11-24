package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Bola {
    //PROPIEDADES
    private double x;
    private double y;
    private double velocidadX;
    private double velocidadY;
    private boolean estado; // Si esta en la mesa o en una tronera
    private final int puntaje;
    private final int bola;
    
    //METODOS
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
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
    
    public void paint(Graphics g, JPanel panel){
        switch(bola){
            case 0 : { // BOLA BLANCA
                g.setColor(new Color(0, 0, 0)); 
                break;
            } case 1 : { // BOLA 1 LISA
                g.setColor(new Color(200, 10, 10)); 
                break;
            } case 2 : { // BOLA 2 LISA
                g.setColor(new Color(10, 200, 10)); 
                break;
            } case 3 : { // BOLA 3 LISA
                g.setColor(new Color(10, 10, 200));
                break;
            } case 4 : { // BOLA 4 LISA
                g.setColor(new Color(10, 200, 200));
                break;
            } case 5 : { // BOLA 5 LISA
                g.setColor(new Color(200, 10, 200));
                break;
            } case 6 : { // BOLA 6 LISA
                g.setColor(new Color(200, 200, 10)); 
                break;
            } case 7 : { // BOLA 7 LISA
                g.setColor(new Color(100, 100, 100)); 
                break;
            } case 8 : { // BOLA 8 NEGRA
                g.setColor(new Color(250, 250, 250)); 
                break;
            } case 9 : { // BOLA 9 RAYADA
                g.setColor(new Color(200, 10, 10)); 
                break;
            } case 10 : { // BOLA 10 RAYADA
                g.setColor(new Color(10, 200, 10)); 
                break;
            } case 11 : { // BOLA 11 RAYADA
                g.setColor(new Color(10, 10, 200)); 
                break;
            } case 12 : { // BOLA 12 RAYADA
                g.setColor(new Color(10, 200, 200)); 
                break;
            } case 13 : { // BOLA 13 RAYADA
                g.setColor(new Color(200, 10, 200)); 
                break;
            } case 14 : { // BOLA 14 RAYADA
                g.setColor(new Color(200, 200, 10)); 
                break;
            } case 15 : { // BOLA 15
                g.setColor(new Color(100, 100, 100)); 
                break;
            }
        }
        g.fillOval((int)x, (int)y, 30, 30);
    }
    
    public Bola(double x, double y, int puntaje, int bola){
        this.x = x;
        this.y = y;
        velocidadX = 0;
        velocidadY = 0;
        estado = true; // Si esta en la mesa o no
        this.puntaje = puntaje;
        this.bola = bola;
    }
}