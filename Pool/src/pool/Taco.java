package pool;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

/** 
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1, 03 de diciembre de 2022
 */
public class Taco {
    //PROPIEDADES
    private float x; // Posicion con respecto a la horizontal
    private float y; // Posicion con respecto a la vertical
    private float cos; // Guarda el seno del taco con respecto a la Bola Blanca
    private float sen; // Guarda el coseno del taco con respecto a la Bola Blanca
    private final Bola bolaBlanca; // Se usa para poder alterar la velocidad de la Bola Blanca
    private boolean turnoAcabado; // guarda true si puedes golpear con el taco y false en caso contrario 
    private MesaBillar mesaBillar;
    
    //METODOS
    /**
     * Setter de propiedades x e y
     * @param x
     * @param y 
     */
    public void setXY(float x, float y){
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
            float Fuerza = 25;
            bolaBlanca.setVelocidadX(Fuerza*-cos);
            bolaBlanca.setVelocidadY(Fuerza*sen);
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
            mesaBillar.getJugadorActual().paintTaco(g,panel);
            Polygon taco = new Polygon();
            taco.addPoint(Math.round(x+30*cos+2*sen),Math.round(y-30*sen+2*cos)); //Parte cercana a la bola
            taco.addPoint(Math.round(x+30*cos-2*sen),Math.round(y-30*sen-2*cos));
            taco.addPoint(Math.round(x+400*cos-5*sen), Math.round(y-400*sen-5*cos)); // Parte lejana a la bola 
            taco.addPoint(Math.round(x+400*cos+5*sen), Math.round(y-400*sen+5*cos));
            g.drawPolygon(taco);
            g.fillPolygon(taco);
            
            Color c = new Color(255, 255, 255, 100 );
            g.setColor(c);
            Polygon trayectoria = new Polygon();
            trayectoria.addPoint(Math.round(x-30*cos+1*sen),Math.round(y+30*sen+1*cos)); //Parte cercana a la bola
            trayectoria.addPoint(Math.round(x-30*cos-1*sen),Math.round(y+30*sen-1*cos));
            trayectoria.addPoint(Math.round(x-400*cos-1*sen), Math.round(y+400*sen-1*cos)); // Parte lejana a la bola 
            trayectoria.addPoint(Math.round(x-400*cos+1*sen), Math.round(y+400*sen+1*cos));
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
    public Taco(int x,int y, Bola bolaBlanca, MesaBillar mb){
        this.bolaBlanca = bolaBlanca;
        this.x = x;
        this.y = y;
        this.mesaBillar = mb;
    }
}
