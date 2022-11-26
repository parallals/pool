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
    /**
     * Getter de x
     * @return x
     */
    public double getX(){
        return x;
    }
    /**
     * Getter de y
     * @return y
     */
    public double getY(){
        return y;
    }
    /**
     * Setter de x
     * @param x 
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Setter de y
     * @param y 
     */
    public void setY(int y){
        this.y = y;
    }
    /**
     * Setter de xy
     * @param x
     * @param y 
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Getter de la velocidad en x
     * @return  velocidad en X
     */
    public double getVelocidadX(){
        return velocidadX;
    }
    /**
     * Getter de la velocidad en y
     * @return velocidad en Y
     */
    public double getVelocidadY(){
        return velocidadY;
    }
    /**
     * Setter de la velocidad en x
     * @param velocidadX 
     */
    public void setVelocidadX(double velocidadX){
        this.velocidadX = velocidadX;
    }
    /**
     * Setter de la velocidad en y
     * @param velocidadY 
     */
    public void setVelocidadY(double velocidadY){
        this.velocidadY = velocidadY;
    }
    /**
     * Getter del Estado de la bola
     * @return El estado 
     */
    public boolean getEstado(){
        return estado;
    }
    /**
     * Setter del Estado de la bola
     * @param estado 
     */
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    /**
     * Getter del puntaje de la bola
     * @return puntaje de la bola
     */
    public int getPuntaje(){
        return puntaje;
    }
    public void startmoveBola(float direccionX, float direccionY){
        velocidadX = velocidadX*-1*direccionX;
        velocidadY = velocidadY*-1*direccionY;
        System.out.println(velocidadX);System.out.println(velocidadY);
    }
    public void moveBola(int velocidad){
        x = velocidadX + x;
        y = velocidadY + y;
    }
    /**
     * Funcion de paint de bola
     * @param g
     * @param panel 
     */
    public void paint(Graphics g, JPanel panel){
        switch(bola){
            case 0 : { // BOLA BLANCA
                g.setColor(Color.white); 
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
                g.setColor(new Color(0, 0, 0)); 
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
    /**
     * Constructor de Bola
     * @param x Coordenada x de la bola
     * @param y Coordenada y de la bola
     * @param puntaje Puntaje correspondiente
     * @param bola Tipo de bola (Numero int del 1 al 15)
     */
    public Bola(double x, double y, int puntaje, int bola){
        this.x = x;
        this.y = y;
        velocidadX = 20;
        velocidadY = 20;
        estado = true; // Si esta en la mesa o no
        this.puntaje = puntaje;
        this.bola = bola;
    }
}