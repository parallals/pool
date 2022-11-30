package pool;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class Taco {
    //PROPIEDADES
    private int x; // Posicion con respecto a la horizontal
    private int y; // Posicion con respecto a la vertical
    private double cos = 0; // Guarda el seno del taco con respecto a la Bola Blanca
    private double sen = 0; // Guarda el coseno del taco con respecto a la Bola Blanca
    private final Bola bolaBlanca; // Se usa para poder alterar la velocidad de la Bola Blanca
    private boolean turnoAcabado; // guarda true si puedes golpear con el taco y false en caso contrario 
    
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
     * Setter de propiedades cos y sen
     * @param cos
     * @param sen 
     */
    public void setCosSen(float cos, float sen){
        this.cos = cos;
        this.sen = sen;
    }
    /**
     * Funcion que cambia la velocidad de la Bola Blanca con respecto a la fuerza que se le golpea 
     */
    public void golpearBola(){
        if(turnoAcabado == true){
            double Fuerza = 25;
            bolaBlanca.setVelocidadX((double)Fuerza*-cos);
            bolaBlanca.setVelocidadY((double)Fuerza*sen);
        }
    }
    /**
     * Setter de propiedad turnoAcabado
     * @param turnoAcabado 
     */
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
            Polygon taco = new Polygon();
            taco.addPoint((int)(x+30*cos+2*sen),(int)(y-30*sen+2*cos)); //Parte cercana a la bola
            taco.addPoint((int)(x+30*cos-2*sen),(int)(y-30*sen-2*cos));
            taco.addPoint((int)(x+400*cos-5*sen), (int)(y-400*sen-5*cos)); // Parte lejana a la bola 
            taco.addPoint((int)(x+400*cos+5*sen), (int)(y-400*sen+5*cos));
            g.drawPolygon(taco);
            g.fillPolygon(taco);
            
            Color c = new Color(255, 255, 255, 100 );
            g.setColor(c);
            Polygon trayectoria = new Polygon();
            trayectoria.addPoint((int)(x-30*cos+1*sen),(int)(y+30*sen+1*cos)); //Parte cercana a la bola
            trayectoria.addPoint((int)(x-30*cos-1*sen),(int)(y+30*sen-1*cos));
            trayectoria.addPoint((int)(x-400*cos-1*sen), (int)(y+400*sen-1*cos)); // Parte lejana a la bola 
            trayectoria.addPoint((int)(x-400*cos+1*sen), (int)(y+400*sen+1*cos));
            g.drawPolygon(trayectoria);
            g.fillPolygon(trayectoria);
        }
    }
    /**
     * Constructor Taco
     * @param x
     * @param y 
     * @param bolaBlanca
     */
    public Taco(int x,int y, Bola bolaBlanca){
        this.bolaBlanca = bolaBlanca;
        this.x = x;
        this.y = y;
    }
}
