package pool;

import java.awt.*;
import javax.swing.*;

public class Jugador {
    private int Puntaje;
    private int numJugador;
    /**
     * paint del Taco del jugador
     * @param g 
     */
    public void paintTaco (Graphics g){
        switch(numJugador){
            case 0:
                g.setColor(Color.red);
                break;
            case 1:
                g.setColor(Color.blue);
                break;
        }
    
    }
    
    public void paintImagenJugador(Graphics g, JPanel panel){
        switch(numJugador){
            case 0:
                Image i0 = new ImageIcon(this.getClass().getResource("../Textures/jugador1.jpg")).getImage();
                g.drawImage(i0, 900, 650, 100, 100, panel);
                break;
            case 1:
                Image i1 = new ImageIcon(this.getClass().getResource("../Textures/jugador2.png")).getImage();
                g.drawImage(i1, 900, 650, 100, 100, panel);
                break;    
        }
    }
    /**
     * Paint del jugador
     * @param g 
     */
    public void paintPuntaje (Graphics g, JPanel panel){
        switch(numJugador){
            case 0:
                g.setColor(Color.red);               
                break;
            case 1:
                g.setColor(Color.blue);
                break;
        }
                g.setFont(new Font("Calibri",Font.ITALIC,20));
                String s = "Puntaje: " + Integer.toString(Puntaje);
                g.drawString(s, 1100, 700);                 
    }
    /**
     * getter del numero del jugador
     * @return 
     */
    public int getNumJugador(){
        return numJugador;
    }
    /**
     * getter del puntaje del jugador
     * @return 
     */
    public int getPuntaje(){
        return Puntaje;
    }    
    /**
     * setter del puntaje
     * @param n 
     */
    public void setPuntaje(int n){
        Puntaje = n;
    }        
    /**
     * constructor
     * @param n 
     */
    public Jugador(int n){
        this.numJugador = n;
        this.Puntaje = 0;
    }
}
