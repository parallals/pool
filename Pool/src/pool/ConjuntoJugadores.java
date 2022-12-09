package pool;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Clase que guarda Jugadores
 * @author Diego
 * @version versión  1, 09 de diciembre de 2022
 */ 
public class ConjuntoJugadores {
    //PROPIEDADES
    private MesaBillar mesaBillar;
    private final ArrayList<Jugador> jugadores; // Guarda una referencia de los Jugadores actuales.
    private Jugador jugadorActual; // Guarda una referencia al Jugador actual.
    //METODOS
    
        
    /**
     * Metodo que cambia el turno para multiples jugadores.
    */
    public void cambiaTurno(){
        if(jugadores.size() != 1 && mesaBillar.getConjunto().getTurnoAcabado()==false){
            if(jugadorActual.getNumJugador() == jugadores.size()-1){
                jugadorActual = jugadores.get(0);
            }else{
                jugadorActual = jugadores.get(jugadorActual.getNumJugador()+1);
            }
        }
    }
    
    /**
     * Metodo Getter de jugadorActual.
     * @return Jugador del turno actual.
     */
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public void setMesaBillar(MesaBillar mesaBillar){
        this.mesaBillar = mesaBillar;
    }
    
    /**
     * Metodo Setter de players.
     * @param cantidad Numero de jugadores.
     */
    public void setPlayers(int cantidad){
        if(mesaBillar.getConjunto().getTurnoAcabado()==true){
            jugadores.clear();
            for(int i = 0 ; i<cantidad ; i++){
                jugadores.add(new Jugador(i));
            }
            jugadorActual = jugadores.get(0);
            mesaBillar.reiniciarJuego();
        }
    }
    
    /**
     * Metodo Getter de la cantidad de jugadores.
     * @return int cantidad de jugadores actuales.
     */
    public int getCantidadJugadores(){
        return jugadores.size();
    }
    
    public void reiniciarJugadores(){
        for(int i=0 ; i<jugadores.size() ; i++){
            jugadores.get(i).setPuntaje(0);
        }
        jugadorActual=jugadores.get(0);
    }
    
    public void paint(Graphics g, JPanel panel){
        jugadorActual.paintJugador(g,panel);
    }
    
    public ConjuntoJugadores(){
        jugadores = new ArrayList<>();
        jugadorActual = new Jugador(0);
        jugadores.add(jugadorActual);
    }
}
