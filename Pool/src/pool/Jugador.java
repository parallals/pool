package pool;

import java.awt.*;
import javax.swing.*;

/** 
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.1, 07 de diciembre de 2022
 */
public class Jugador {
    //PROPIEDADES
    private int Puntaje;
    private final int numJugador;
    
    //METODOS
    /**
     * Metodo Getter del numero del jugador
     * @return numJugador
     */
    public int getNumJugador(){
        return numJugador;
    }
    /**
     * Metodo Getter del puntaje del jugador
     * @return Puntaje
     */
    public int getPuntaje(){
        return Puntaje;
    }    
    /**
     * Metodo Getter del puntaje
     * @param n 
     */
    public void setPuntaje(int n){
        Puntaje = n;
    }        
    /**
     * Metodo que da el color de Taco segun el Jugador
     * @param g 
     * @param panel 
     */
    public void colorTaco (Graphics g){
        switch(numJugador){
            case 0:
                g.setColor(Color.red);
                break;
            case 1:
                g.setColor(Color.blue);
                break;
            case 2:
                g.setColor(Color.green);
                break;
            case 3:
                g.setColor(Color.yellow);
                break;                
            default:
                g.setColor(Color.white);
        }
    }
    /**
     * Metodo paint de Jugador
     * @param g
     * @param panel 
     */
    public void paintJugador(Graphics g, JPanel panel){
        try{
            switch(numJugador){
            case 0:
                Image i0 = new ImageIcon(this.getClass().getResource("../Textures/jugador1.jpg")).getImage();
                g.drawImage(i0, 900, 650, 100, 100, panel);
                g.setColor(Color.red);
                break;
            case 1:
                Image i1 = new ImageIcon(this.getClass().getResource("../Textures/jugador2.png")).getImage();
                g.drawImage(i1, 900, 650, 100, 100, panel);
                g.setColor(Color.blue);
                break; 
            case 2:
                Image i2 = new ImageIcon(this.getClass().getResource("../Textures/jugador3.jpeg")).getImage();
                g.drawImage(i2, 900, 650, 100, 100, panel);
                g.setColor(Color.green);
                break;
            case 3:
                Image i3 = new ImageIcon(this.getClass().getResource("../Textures/jugador4.jpg")).getImage();
                g.drawImage(i3, 900, 650, 100, 100, panel);
                g.setColor(Color.yellow);
                break;
            }
        }catch(Exception e){
                    System.out.println("Fallo al cargar la imagen");
        }
        g.setFont(new Font("Calibri",Font.ITALIC,20));
        String s = "Puntaje: " + Integer.toString(Puntaje);
        g.drawString(s, 1100, 700);
    }
    /**
     * Metodo Constructor de Jugador
     * @param n 
     */
    public Jugador(int n){
        this.numJugador = n;
        this.Puntaje = 0;
    }
}
