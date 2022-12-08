package pool;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

/** 
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.1, 07 de diciembre de 2022
 */
public class Bola {
    //PROPIEDADES
    private float x; // Posicion con respecto a la horizontal.
    private float y; // Posicion con respecto a la vertical.
    private float velocidadX; // Velocidad con respecto a la horizontal.
    private float velocidadY; // Velocidad con respecto a la vertical.
    private final double aceleracion; // Perdida de velocidad debido al roce.
    private final int puntaje; // cantidad de puntos que da al caer en una tronera.
    private final int serie; // Diseño que tendra.
    //METODOS
    /**
     * Metodo Getter de serie
     * @return serie 
     */
    public int getSerie(){
        return serie;
    }
    /**
     * Metodo Getter de x
     * @return x
     */
    public float getX(){
        return x;
    }
    /**
     * Metodo Getter de y
     * @return y
     */
    public float getY(){
        return y;
    }
    /**
     * Metodo Setter de x
     * @param x 
     */
    public void setX(float x){
        this.x = x;
    }
    /**
     * Metodo Setter de y
     * @param y 
     */
    public void setY(float y){
        this.y = y;
    }
    /**
     * Metodo Setter de x e y
     * @param x
     * @param y 
     */
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    /**
     * Metodo Getter de la velocidad en x
     * @return  velocidad en X
     */
    public float getVelocidadX(){
        return velocidadX;
    }
    /**
     * Metodo Getter de la velocidad en y
     * @return velocidad en Y
     */
    public float getVelocidadY(){
        return velocidadY;
    }
    /**
     * Metodo Setter de la velocidad en x
     * @param velocidadX 
     */
    public void setVelocidadX(float velocidadX){
        this.velocidadX = velocidadX;
    }
    /**
     * Metodo Setter de la velocidad en y
     * @param velocidadY 
     */
    public void setVelocidadY(float velocidadY){
        this.velocidadY = velocidadY;
    }
    /**
     * Metodo Getter del puntaje de la bola
     * @return puntaje de la bola
     */
    public int getPuntaje(){
        return puntaje;
    }
    /**
     * Metodo que maneja el movimiento que tendra Bola (No contempla colisiones). ticks sirve para suavizar el movimiento y asi tener mejor deteccion de colision.
     * @param ticks
     */
    public void movimientoBola(int ticks){
        double velocidadTotal = Math.sqrt((velocidadX*velocidadX)+(velocidadY*velocidadY));
        if(velocidadTotal > 0){
            if(velocidadTotal - aceleracion/ticks > 0){
                velocidadTotal = velocidadTotal - aceleracion/ticks;         
            }else{
                velocidadX = 0;
                velocidadY = 0;
                velocidadTotal = 0; 
            }
        }
        if(velocidadTotal != 0){
            double angulo = Math.atan2(velocidadY, velocidadX);
            velocidadX = (float)(velocidadTotal*Math.cos(angulo));
            velocidadY = (float)(velocidadTotal*Math.sin(angulo));
            x = velocidadX/ticks + x;
            y = velocidadY/ticks+ y;
        }
    }
    /**
     * Metodo paint de bola
     * @param g
     * @param panel 
     */
    public void paint(Graphics g, JPanel panel){
        switch(serie){
            case 0 : { // BOLA BLANCA
                g.setColor(Color.white); 
                g.fillOval((int)x, (int)y, 30, 30);                
                break;
            } case 1 : { // BOLA 1 LISA
                Image i1 = new ImageIcon(this.getClass().getResource("../Textures/1.png")).getImage();
                g.drawImage(i1, (int)x, (int)y, 30, 30, panel);
                break;
            } case 2 : { // BOLA 2 LISA
                Image i2 = new ImageIcon(this.getClass().getResource("../Textures/2.png")).getImage();
                g.drawImage(i2, (int)x, (int)y, 30, 30, panel);
                break;
            } case 3 : { // BOLA 3 LISA
                Image i3 = new ImageIcon(this.getClass().getResource("../Textures/3.png")).getImage();
                g.drawImage(i3, (int)x, (int)y, 30, 30, panel);
                break;
            } case 4 : { // BOLA 4 LISA
                Image i4 = new ImageIcon(this.getClass().getResource("../Textures/4.png")).getImage();
                g.drawImage(i4, (int)x, (int)y, 30, 30, panel);
                break;
            } case 5 : { // BOLA 5 LISA
                Image i5 = new ImageIcon(this.getClass().getResource("../Textures/5.png")).getImage();
                g.drawImage(i5, (int)x, (int)y, 30, 30, panel);
                break;
            } case 6 : { // BOLA 6 LISA
                Image i6 = new ImageIcon(this.getClass().getResource("../Textures/6.png")).getImage();
                g.drawImage(i6, (int)x, (int)y, 30, 30, panel);
                break;
            } case 7 : { // BOLA 7 LISA
                Image i7 = new ImageIcon(this.getClass().getResource("../Textures/7.png")).getImage();
                g.drawImage(i7, (int)x, (int)y, 30, 30, panel);
                break;
            } case 8 : { // BOLA 8 NEGRA
                Image i8 = new ImageIcon(this.getClass().getResource("../Textures/8.png")).getImage();
                g.drawImage(i8, (int)x, (int)y, 30, 30, panel);
                break;
            } case 9 : { // BOLA 9 RAYADA
                Image i9 = new ImageIcon(this.getClass().getResource("../Textures/9.png")).getImage();
                g.drawImage(i9, (int)x, (int)y, 30, 30, panel);
                break;
            } case 10 : { // BOLA 10 RAYADA
                Image i10 = new ImageIcon(this.getClass().getResource("../Textures/10.png")).getImage();
                g.drawImage(i10, (int)x, (int)y, 30, 30, panel);
                break;
            } case 11 : { // BOLA 11 RAYADA
                Image i11 = new ImageIcon(this.getClass().getResource("../Textures/11.png")).getImage();
                g.drawImage(i11, (int)x, (int)y, 30, 30, panel);
                break;
            } case 12 : { // BOLA 12 RAYADA
                Image i12 = new ImageIcon(this.getClass().getResource("../Textures/12.png")).getImage();
                g.drawImage(i12, (int)x, (int)y, 30, 30, panel);
                break;
            } case 13 : { // BOLA 13 RAYADA
                Image i13 = new ImageIcon(this.getClass().getResource("../Textures/13.png")).getImage();
                g.drawImage(i13, (int)x, (int)y, 30, 30, panel);
                break;
            } case 14 : { // BOLA 14 RAYADA
                Image i14 = new ImageIcon(this.getClass().getResource("../Textures/14.png")).getImage();
                g.drawImage(i14, (int)x, (int)y, 30, 30, panel);
                break;
            } case 15 : { // BOLA 15
                Image i15 = new ImageIcon(this.getClass().getResource("../Textures/15.png")).getImage();
                g.drawImage(i15, (int)x, (int)y, 30, 30, panel);
                break;
            }
        }
    }
    /**
     * Metodo Constructor de Bola
     * @param x Coordenada x de la bola
     * @param y Coordenada y de la bola
     * @param puntaje Puntaje correspondiente
     * @param bola Tipo de bola (Numero int del 1 al 15)
     */
    public Bola(float x, float y, int puntaje, int bola){
        this.x = x;
        this.y = y;
        velocidadX = 0;
        velocidadY = 0;
        aceleracion = 0.2;
        this.puntaje = puntaje;
        this.serie = bola;
    }
}