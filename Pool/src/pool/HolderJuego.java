package pool;

import static angular.Angular.anguloPI;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author Diego  Venegas
 * @version versión  1, 12 de diciembre de 2022
 */
public class HolderJuego {
    //PROPIEDADES
    private final MesaBillar mesaBillar;
    private final Taco taco;
    private final ConjuntoJugadores conjuntoJugadores;
    
    //METODOS
    /**
     * 
     */
    public void ReiniciarJuego(){
        mesaBillar.reiniciarJuego();
    }
    /**
     * 
     */
    public void AgregarBolas(){
        mesaBillar.getConjunto().agregarBolas();
    }
    /**
     * 
     */
    public void RetirarBolas(){
        mesaBillar.getConjunto().retirarBolas();
    }
    /**
     * 
     */
    public void CambiarJugadores(int n){
        conjuntoJugadores.setPlayers(n);
    }
    /**
     * 
     */
    public void MovimientoMouse(int x, int y){
        taco.setCosSen(anguloPI(mesaBillar.getBola(0).getX()+15, mesaBillar.getBola(0).getY()+15, x, y));
    }
    /**
     * 
     */
    public void PulsarMouse(Point p){
        taco.setPulsado(p);
    }
    /**
     * 
     */
    public void SoltarMouse(Point p){
        taco.setSuelto(p);
    }
    /**
     * 
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
     * Metodo paint de holder, hace un llamado al paint de todas las clases principales.
     */
    public void paint(Graphics g, JPanel panel){
        mesaBillar.paint(g, panel);
        conjuntoJugadores.paint(g, panel);
        taco.paint(g, panel);
    }
    /**
     * Contructor de HolderJuego
     */
    public HolderJuego(){
        conjuntoJugadores = new ConjuntoJugadores();
        mesaBillar = new MesaBillar(conjuntoJugadores);
        conjuntoJugadores.setMesaBillar(mesaBillar);
        taco = new Taco(mesaBillar.getBola(0), conjuntoJugadores);
    }
}
