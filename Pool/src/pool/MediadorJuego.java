package pool;

import static angular.Angular.anguloPI;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * Clase que almacena todas las clases principales de Pool y da acceso a panel principal de una manera mas ordenada.
 * @author Diego  Venegas
 * @version versión  1.2, 12 de diciembre de 2022
 */
public class MediadorJuego {
    //PROPIEDADES
    private static MediadorJuego instancia = null;
    private final MesaBillar mesaBillar;
    private final Taco taco;
    private final ConjuntoJugadores conjuntoJugadores;
    
    //METODOS
    /**
     * Metodo que da acceso a Reiniciar el Juego.
     */
    public void ReiniciarJuego(){
        mesaBillar.reiniciarJuego();
    }
    /**
     * Metodo que da acceso a Agregar Mas Bolas.
     */
    public void AgregarBolas(){
        mesaBillar.getConjunto().agregarBolas();
    }
    /**
     * Metodo que da acceso a Retirar Bolas.
     */
    public void RetirarBolas(){
        mesaBillar.getConjunto().retirarBolas();
    }
    /**
     * Metodo que da acceso a Cambiar la Cantidad de Jugadores.
     * @param n el numero de jugadores al que se cambiara
     */
    public void CambiarJugadores(int n){
        conjuntoJugadores.setPlayers(n);
    }
    /**
     * Metodo que obtiene las coordenadas del mouse.
     * @param x Posicion con respecto a la horizontal.
     * @param y Posicion con respecto a la vertical.
     */
    public void MovimientoMouse(int x, int y){
        taco.setCosSen(anguloPI(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15, x, y));
    }
    /**
     * Metodo que obtiene las coordenadas del mouse al ser pulsado.
     * @param p Coordenadas del mouse.
     */
    public void PulsarMouse(Point p){
        taco.setPulsado(p);
    }
    /**
     * Metodo que obtiene las coordenadas del mouse al ser soltado.
     * @param p Coordenadas del mouse.
     */
    public void SoltarMouse(Point p){
        taco.setSuelto(p);
    }
    /**
     * Metodo que da acceso a Golpear Bola Blanca.
     */
    public void GolpearBola(){
        taco.golpearBola();
    }
    /**
     * Metodo que se Ocupara en ActionPerformed del PanelPrincipal
     */
    public void ActionPerformed(){
        mesaBillar.getConjunto().Movimiento();
        taco.setTurnoAcabado(mesaBillar.getConjunto().TurnoAcabado());
        taco.setXY(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15);
    }
    /**
     * Metodo paint de Holder, hace un llamado al paint de todas las clases principales.
     * @param g clase Graphics.
     * @param panel clase JPanel.
     */
    public void paint(Graphics g, JPanel panel){
        mesaBillar.paint(g, panel);
        conjuntoJugadores.paint(g, panel);
        taco.paint(g, panel);
    }
    /**
     * Metodo que llama al contructor, sigue el patro Singleton.
     * @return retorna un unico HolderJuego.
     */
    public static MediadorJuego getInstancia( ){
        if(instancia == null){
            instancia = new MediadorJuego( );
        }
        return instancia;
    }
    /**
     * Contructor de privado HolderJuego.
     */
    private MediadorJuego(){
        conjuntoJugadores = new ConjuntoJugadores();
        mesaBillar = new MesaBillar(conjuntoJugadores);
        conjuntoJugadores.setMesaBillar(mesaBillar);
        taco = new Taco(mesaBillar.getBola(0), conjuntoJugadores);
    }
}
