package pool;

import java.awt.*;
import javax.swing.*;

/** 
 * Clase Jugador.
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.3, 09 de diciembre de 2022
 */
public class Jugador {
    //PROPIEDADES
    private int puntaje;
    private final int numJugador;
    
    //METODOS
    /**
     * Metodo Getter del numero del jugador.
     * @return int numero del Jugador.
     */
    public int getNumJugador(){
        return numJugador;
    } 
    /**
     * Metodo Getter del puntaje.
     * @param puntaje.
     */
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    /**
     * Metodo que suma puntaje.
     * @param puntaje.
     */
    public void sumarPuntaje(int puntaje){
        this.puntaje = this.puntaje+puntaje;
    }       
    /**
     * Metodo que da el color de Taco segun el Jugador.
     * @param g clase Graphics.
     */
    public void colorTaco (Graphics g){
        switch(numJugador){
            case 0 -> {
                g.setColor(Color.red);
            } case 1 -> {
                g.setColor(Color.blue);
            } case 2 -> {
                g.setColor(Color.green);
            } case 3 -> {
                g.setColor(Color.yellow);
            } default -> {
                g.setColor(Color.white);
            }
        }
    }
    /**
     * Metodo paint del Jugador.
     * @param g clase Graphics.
     * @param panel clase JPanel.
     */
    public void paintJugador(Graphics g, JPanel panel){
        try{
            switch(numJugador){
                case 0 -> {
                    Image i0 = new ImageIcon(this.getClass().getResource("../Textures/jugador1.png")).getImage();
                    g.drawImage(i0, 900, 650, 100, 100, panel);
                    g.setColor(Color.red);
                } case 1 -> {
                    Image i1 = new ImageIcon(this.getClass().getResource("../Textures/jugador2.png")).getImage();
                    g.drawImage(i1, 900, 650, 100, 100, panel);
                    g.setColor(Color.blue);
                } case 2 -> {
                    Image i2 = new ImageIcon(this.getClass().getResource("../Textures/jugador3.png")).getImage();
                    g.drawImage(i2, 900, 650, 100, 100, panel);
                    g.setColor(Color.green);
                } case 3 -> {
                    Image i3 = new ImageIcon(this.getClass().getResource("../Textures/jugador4.png")).getImage();
                    g.drawImage(i3, 900, 650, 100, 100, panel);
                    g.setColor(Color.yellow);
                }
            }
        }catch(Exception e){
                    System.out.println("Fallo al cargar imagen");
        }
        g.setFont(new Font("Calibri",Font.ITALIC,20));
        String s = "Puntaje: " + Integer.toString(puntaje);
        g.drawString(s, 1050, 700);
    }
    /**
     * Metodo Constructor de Jugador.
     * @param numJugador Numero del jugador.
     */
    public Jugador(int numJugador){
        this.numJugador = numJugador;
        this.puntaje = 0;
    }
}
