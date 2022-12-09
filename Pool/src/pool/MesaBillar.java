package pool;

import static angular.Angular.distEntre2Puntos;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

/** 
 * a
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.1, 03 de diciembre de 2022
 */
public class MesaBillar {
    //PROPIEDADES
    private final int x; // Posicion con respecto a la horizontal.
    private final int y; // Posicion con respecto a la vertical.
    ConjuntoBolas conjuntoBolas; // Guarda el Conjunto de Bolas.
    private final ArrayList<Bola> Tronera ;// Guarda las Bolas que cayeron en alguna Tronera
    private final ArrayList<Jugador> jugadores; // Guarda una referencia de los Jugadores actuales
    private Jugador jugadorActual; // Guarda una referencia al Jugador actual
    
    //METODOS
    /**
     * Metodo Getter de X
     * @return x
     */
    public int getX(){
        return x;
    }
    /**
     * Metodo Getter de y
     * @return y
     */
    public int getY(){
        return y;
    }
    /**
     * Metodo Getter de la cantidad de jugadores
     * @return 
     */
    public int getCantidadJugadores(){
        return jugadores.size();
    }
    /**
     * Metodo Getter de jugadorActual
     * @return 
     */
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    /**
     * Metodo Setter de players
     * @param p 
     */
    public void setPlayers(int p){
        jugadores.clear();
        for(int i = 0; i<p;++i){
            Jugador Aux = new Jugador(i);
            jugadores.add(Aux);
        }
        jugadorActual = jugadores.get(0);
        reiniciarJuego();      
    }
    /**
     * Metodo Getter de Bola
     * @return conjuntoBolas
     */
    public Bola getBola(int i){
        return conjuntoBolas.getBola(i);   
    }
    /**
     * Metodo Getter de conjuntoBolas
     * @return  conjuntoBolas
     */
    public ConjuntoBolas getConjunto(){
        return conjuntoBolas;
    }
    /**
     * Metodo que quita bolas que hay en tronera
     * @return 
     */
    public void VaciarTronera(){
        int aux = Tronera.size();
        for(int i=0 ; i<aux ; i++){
            conjuntoBolas.getConjunto().get(0).setXY(0, 400);
            conjuntoBolas.getConjunto().add(Tronera.remove(0));
        }
    }  
    /**
     * Metodo que revisa cuantas bolas hay en tronera
     * @return 
     */
    public boolean TroneraVacia(){
        return Tronera.isEmpty();
    }    
    /**
     * Getter de X
     * Metodo que cambia el turno para multiples jugadores
     * @return x     */
    public void cambiaTurno(){
        if(jugadores.size() != 1 && conjuntoBolas.getTurnoAcabado()==false){
            if(jugadorActual.getNumJugador() == jugadores.size()-1){
                jugadorActual = jugadores.get(0);
            }else{
                jugadorActual = jugadores.get(jugadorActual.getNumJugador()+1);
            }
        }
    }
    /**
     * Metodo que verifica si hay bolas que caigan en una tronera
     * @param b1
     */
    public boolean bolaCaeTronera(Bola b1){
        if((distEntre2Puntos(b1.getX()+15, b1.getY()+15, x-5, y-5) < 40) //Tronera 1
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+(1064/2), y-5) < 40) //Tronera 2
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+1064-40+45, y-5) < 40) //Tronera 3
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x-5, y+501-(40-25)) < 40) //Tronera 4
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+(1064/2), y+501-(40-25)) < 40) //Tronera 5
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+1064-40+45, y+501-(40-25)) < 40)){ //Tronera 6
            if(b1.getSerie() == 0){
                //Puntaje = Puntaje + b1.getPuntaje();
                jugadorActual.setPuntaje(jugadorActual.getPuntaje()+b1.getPuntaje());
                b1.setVelocidadX(0);
                b1.setVelocidadY(0);
                boolean aux = false;
                do{
                    b1.setXY( (float)(Math.random()*1034)+x, (float)(Math.random()*451)+y);
                    for(int i = 1; i<conjuntoBolas.getConjunto().size() ; ++i){
                        if(conjuntoBolas.DetectarColision(b1,getBola(i))== true){
                            aux = true;
                        }
                    }
                }while(aux == true);
            }else{
                for(int i=0 ; i<conjuntoBolas.getConjunto().size() ; i++){
                    if(conjuntoBolas.getBola(i).getSerie() == b1.getSerie()){
                        b1.setVelocidadX(0);
                        b1.setVelocidadY(0); 
                        jugadorActual.setPuntaje(jugadorActual.getPuntaje()+b1.getPuntaje());
                        Tronera.add(conjuntoBolas.getConjunto().remove(i));
                        OrdenarTronera();
                        return true;
                    }
                }  
            }
        }
        return false;
    }  
    /**
     * Metodo que Ordena Bolas que no estan en la mesa
     */
    public void OrdenarTronera(){
        for(int i=0 ; i<Tronera.size() ; i++){
            Tronera.get(i).setXY(20, 35+40*i);
        }
    }
    /**
     * Metodo que reinicia el puntaje, velocidad y posicion de Bolas .
     */
    public void reiniciarJuego(){
        VaciarTronera();
        conjuntoBolas.RandomizarBolas();
        for(int i=0; i<jugadores.size(); ++i){
            jugadores.get(i).setPuntaje(0);
        }
        jugadorActual=jugadores.get(0);
    }
    /**
     * Metodo paint de MesaBillar, hace un llamado a ConjuntoBolas
     * @param g clase Graphics
     * @param panel clase JPanel 
     */
    public void paint(Graphics g, JPanel panel){
        //Mesa
        g.setColor(new Color(100, 60, 50)); 
        g.fillRect(x-30, y-30, 1124, 541);
        g.setColor(new Color(30, 130, 80)); // Zona Verde
        g.fillRect(x, y, 1064, 481);
        //Troneras
        g.setColor(new Color(0, 0, 0)); 
        g.fillOval(x-20, y-20, 40, 40);
        g.fillOval(x+512, y-20, 40, 40);
        g.fillOval(x+1044, y-20, 40, 40);
        g.fillOval(x-20, y+461, 40, 40);
        g.fillOval(x+512, y+461, 40, 40);
        g.fillOval(x+1044, y+461, 40, 40);
        //Jugador
        jugadorActual.paintJugador(g,panel);
        //conjuntoBolas
        conjuntoBolas.paint(g, panel);
        for(int i=0 ; i<Tronera.size() ; i++){
            Tronera.get(i).paint(g, panel);
        }
    }
    /**
     * Metodo Contructor de MesaBillar
     */
    public MesaBillar(){
        Tronera = new ArrayList<>();
        x = 100;
        y = 100;
        conjuntoBolas = new ConjuntoBolas(this);
        jugadores = new ArrayList<>();
        jugadorActual = new Jugador(0);
        jugadores.add(jugadorActual);
    }
 
}