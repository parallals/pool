package pool;

import static angular.Angular.distEntre2Puntos;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.Point;

/** 
 * Clase de Taco.
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.3, 09 de diciembre de 2022
 */
public class Taco {
    //PROPIEDADES
    private float x; // Posicion x con respecto a bolaBlanca.
    private float y; // Posicion y con respecto a bolaBlanca.
    private Point mousePulsado; // Punto en el que el cursor fue presionado.
    private Point mouseSuelto;  // Punto en el que el cursor fue soltado.
    boolean pintarTrayectoria; //Si es falso la trayectoria no se pintara, de lo contrario si lo hara.
    private float cos; // Guarda el seno del taco con respecto a la Bola Blanca.
    private float sen; // Guarda el coseno del taco con respecto a la Bola Blanca.
    private final Bola bolaBlanca; // Se usa para poder alterar la velocidad de la Bola Blanca.
    private boolean turnoAcabado; // Guarda true si puedes golpear con el taco y false en caso contrario.
    private final MesaBillar mesaBillar; // Referencia a MesaBillar.
    
    //METODOS
    /**
     * Metodo Setter de propiedades x e y
     * @param x Posicion x con respecto a bolaBlanca.
     * @param y Posicion y con respecto a bolaBlanca.
     */
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    /**
     * Metodo Setter de propiedades cos y sen.
     * @param angulo Angulo de rotacion con respecto a bolaBlanca.
     */
    public void setCosSen(float angulo){
        cos = (float)Math.cos(angulo);
        sen = (float)Math.sin(angulo);
    }
    /**
     * Metodo Setter de mousePulsado.
     * @param pulsado posicion al pulsar el mouse.
     */
    public void setPulsado(Point pulsado){
        if(turnoAcabado == true){
            this.mousePulsado = pulsado;
        }
    }
    /**
     * Metodo Setter de mouseSuelto.
     * @param suelto posicion al soltar el mouse.
     */
    public void setSuelto(Point suelto){
        if(turnoAcabado == true){
            this.mouseSuelto = suelto;
            pintarTrayectoria = true;
        }
    }
    /**
     * Metodo Setter de propiedad turnoAcabado.
     * @param turnoAcabado true en caso de turno acabado y false en caso contrario.
     */
    public void setTurnoAcabado(boolean turnoAcabado){
        this.turnoAcabado = turnoAcabado;
    }
    /**
     * Metodo que cambia la velocidad de la Bola Blanca con respecto a la fuerza que se le golpea.
     */
    public void golpearBola(){
        if(turnoAcabado == true){
            float fuerzaAcumulada = distEntre2Puntos(mousePulsado, mouseSuelto)/6;
            if(fuerzaAcumulada > 50){
                fuerzaAcumulada = 50;
            }
            bolaBlanca.setVelocidadX(fuerzaAcumulada*-cos);
            bolaBlanca.setVelocidadY(fuerzaAcumulada*sen);
            pintarTrayectoria = false;
        }
    }
    /**
     * Metodo paint de Taco.
     * @param g clase Graphics.
     * @param panel clase JPanel.
     */
    public void paint(Graphics g, JPanel panel){
        if(turnoAcabado == true){
            mesaBillar.getJugadorActual().colorTaco(g);
            Polygon taco = new Polygon();
            taco.addPoint(Math.round(x+30*cos+2*sen),Math.round(y-30*sen+2*cos)); //Parte cercana a la bola
            taco.addPoint(Math.round(x+30*cos-2*sen),Math.round(y-30*sen-2*cos));
            taco.addPoint(Math.round(x+400*cos-5*sen), Math.round(y-400*sen-5*cos)); // Parte lejana a la bola 
            taco.addPoint(Math.round(x+400*cos+5*sen), Math.round(y-400*sen+5*cos));
            g.fillPolygon(taco);
            if(pintarTrayectoria ==true){
                float magnitudTrayectoria = distEntre2Puntos(mousePulsado, mouseSuelto)+40;
                if((magnitudTrayectoria-40)/6 > 50){
                    magnitudTrayectoria = 340;
                }
                g.setColor(new Color(255, 255, 255, 100));
                Polygon trayectoria = new Polygon();
                trayectoria.addPoint(Math.round(x-30*cos+1*sen),Math.round(y+30*sen+1*cos)); //Parte cercana a la bola
                trayectoria.addPoint(Math.round(x-30*cos-1*sen),Math.round(y+30*sen-1*cos));
                trayectoria.addPoint(Math.round(x-magnitudTrayectoria*cos-1*sen), Math.round(y+magnitudTrayectoria*sen-1*cos)); // Parte lejana a la bola 
                trayectoria.addPoint(Math.round(x-magnitudTrayectoria*cos+1*sen), Math.round(y+magnitudTrayectoria*sen+1*cos));
                g.fillPolygon(trayectoria);
            }
        }
    }
    /**
     * Metodo Constructor de Taco.
     * @param bolaBlanca a la que golpeara.
     * @param mesaBillar En la que sera ocupado.
     */
    public Taco(Bola bolaBlanca, MesaBillar mesaBillar){
        this.bolaBlanca = bolaBlanca;
        this.x = bolaBlanca.getX();
        this.y = bolaBlanca.getY();
        cos = 0;
        sen = 0;
        mousePulsado = new Point(0,0);
        mouseSuelto = new Point(40,40);
        pintarTrayectoria = false;
        this.mesaBillar = mesaBillar;
        turnoAcabado = true;
    }
}