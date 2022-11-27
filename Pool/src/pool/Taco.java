package pool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class Taco {
    //PROPIEDADES
    private int x;
    private int y;
    private Polygon p;
    private float cos = 0;
    private float sen = 0;
    private final Bola bolaBlanca;
    private boolean turnoAcabado;
    
    //METODOS
    /**
     * Setter de propiedades x e y
     * @param x
     * @param y 
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Setter de propiedades cos y sen (el coseno y seno de la posicion del taco con respecto a la bola, respectivamente. Se inicia con valor 0)
     * @param cos
     * @param sen 
     */
    public void setCosSen(float cos, float sen){
        this.cos = cos;
        this.sen = sen;
    }
    
    public void golpearBola(){
        if(turnoAcabado == true){
            double Fuerza = 30;
            bolaBlanca.setVelocidadX((double)Fuerza*-cos);
            bolaBlanca.setVelocidadY((double)Fuerza*sen);
        }
    }
    
    public void setTurnoAcabado(boolean turnoAcabado){
        this.turnoAcabado = turnoAcabado;
    }
    
    /**
     * Método paint de Taco
     * @param g
     * @param panel 
     */
    public void paint(Graphics g, JPanel panel){
        if(turnoAcabado == true){
            g.setColor(Color.yellow);
            p = new Polygon();
            p.addPoint((int)(x+30*cos+2*sen),(int)(y-30*sen+2*cos)); //Parte cercana a la bola
            p.addPoint((int)(x+30*cos-2*sen),(int)(y-30*sen-2*cos));
            p.addPoint((int)(x+400*cos-5*sen), (int)(y-400*sen-5*cos)); // Parte lejana a la bola 
            p.addPoint((int)(x+400*cos+5*sen), (int)(y-400*sen+5*cos));
            g.drawPolygon(p);
            g.fillPolygon(p);
        }
    }
    /**
     * Constructor Taco
     * @param x
     * @param y 
     */
    public Taco(int x,int y, Bola bolaBlanca){
        this.bolaBlanca = bolaBlanca;
        this.x = x;
        this.y = y;
    }
}
