package pool;

import static angular.Angular.distEntre2Puntos;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

/** 
 * Clase mesaBillar que contiene al ConjuntoBolas.
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.2, 09 de diciembre de 2022
 */
public class MesaBillar {
    //PROPIEDADES
    private final ConjuntoJugadores conjuntoJugadores;
    private final int x; // Posicion con respecto a la horizontal.
    private final int y; // Posicion con respecto a la vertical.
    private final ConjuntoBolas conjuntoBolas; // Guarda el Conjunto de Bolas.
    private final ArrayList<Bola> Tronera ;// Guarda las Bolas que cayeron en alguna Tronera.
    
    //METODOS
    /**
     * Metodo Getter de x.
     * @return int posicion con respecto a la horizontal.
     */
    public int getX(){
        return x;
    }
    /**
     * Metodo Getter de y.
     * @return int posicion con respecto a la vertical.
     */
    public int getY(){
        return y;
    }
    /**
     * Metodo Getter de Bola.
     * @param numero Numero de bola a retirar.
     * @return Bola elegida.
     */
    public Bola getBola(int numero){
        return conjuntoBolas.getBola(numero);   
    }
    /**
     * Metodo Getter de conjuntoBolas.
     * @return ConjuntoBolas retorna todo el conjunto de bolas.
     */
    public ConjuntoBolas getConjunto(){
        return conjuntoBolas;
    }
    /**
     * Metodo que quita bolas que hay en Tronera y los devuelve al conjuntoBolas.
     */
    public void VaciarTronera(){
        int aux = Tronera.size();
        for(int i=0 ; i<aux ; i++){
            conjuntoBolas.getConjunto().add(Tronera.remove(0));
        }
    }  
    /**
     * Metodo que revisa cuantas bolas hay en Tronera.
     * @return boolean, true en caso de estar vacia, false en caso contrario.
     */
    public boolean TroneraVacia(){
        return Tronera.isEmpty();
    }
    /**
     * Metodo que verifica si cayo alguna bola en las troneras.
     * @param bola Bola a revisar.
     * @return true en caso de que haya caido una Bola y false en caso contrario.
     */
    public boolean bolaCaeTronera(Bola bola){
        if((distEntre2Puntos(bola.getX()+15, bola.getY()+15, x-5, y-5) < 40) //Tronera 1
         || (distEntre2Puntos(bola.getX()+15, bola.getY()+15, x+532, y-5) < 40) //Tronera 2
         || (distEntre2Puntos(bola.getX()+15, bola.getY()+15, x+1059, y-5) < 40) //Tronera 3
         || (distEntre2Puntos(bola.getX()+15, bola.getY()+15, x-5, y+486) < 40) //Tronera 4
         || (distEntre2Puntos(bola.getX()+15, bola.getY()+15, x+532, y+486) < 40) //Tronera 5
         || (distEntre2Puntos(bola.getX()+15, bola.getY()+15, x+1059, y+486) < 40)){ //Tronera 6
            if(bola.getSerie() == 0){
                //Puntaje = Puntaje + b1.getPuntaje();
                conjuntoJugadores.getJugadorActual().sumarPuntaje(bola.getPuntaje());
                bola.setVelocidadX(0);
                bola.setVelocidadY(0);
                boolean aux = false;
                do{
                    bola.setXY( (float)(Math.random()*1034)+x, (float)(Math.random()*451)+y);
                    for(int i = 1; i<conjuntoBolas.getConjunto().size() ; ++i){
                        if(conjuntoBolas.DetectarColision(bola,getBola(i))== true){
                            aux = true;
                        }
                    }
                }while(aux == true);
            }else{
                for(int i=0 ; i<conjuntoBolas.getConjunto().size() ; i++){
                    if(conjuntoBolas.getBola(i).getSerie() == bola.getSerie()){
                        bola.setVelocidadX(0);
                        bola.setVelocidadY(0); 
                        conjuntoJugadores.getJugadorActual().sumarPuntaje(bola.getPuntaje());
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
     * Metodo que Ordena Bolas que no estan en la mesa.
     */
    private void OrdenarTronera(){
        for(int i=0 ; i<Tronera.size() ; i++){
            Tronera.get(i).setXY(20, 35+40*i);
        }
    }
    /**
     * Metodo que reinicia el puntaje, velocidad y posicion de Bolas.
     */
    public void reiniciarJuego(){
        VaciarTronera();
        conjuntoBolas.RandomizarBolas();
        conjuntoJugadores.reiniciarJugadores();
    }
    /**
     * Metodo paint de MesaBillar, hace un llamado a ConjuntoBolas.
     * @param g clase Graphics.
     * @param panel clase JPanel.
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
        //conjuntoBolas
        conjuntoBolas.paint(g, panel);
        for(int i=0 ; i<Tronera.size() ; i++){
            Tronera.get(i).paint(g, panel);
            Tronera.get(i).paintContorno(g);
        }
    }
    /**
     * Metodo Contructor de MesaBillar.
     * @param conjuntoJugadores Clase Conjunto Jugadores
     */
    public MesaBillar(ConjuntoJugadores conjuntoJugadores){
        this.conjuntoJugadores = conjuntoJugadores;
        Tronera = new ArrayList<>();
        x = 100;
        y = 100;
        conjuntoBolas = new ConjuntoBolas(this, conjuntoJugadores);
    }
}