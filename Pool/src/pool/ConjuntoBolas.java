package pool;

import static angular.Angular.distEntre2Puntos;
import static angular.Angular.anguloPI;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
//import java.util.Random;

/** 
 * Clase que almacena las Bolas en la mesaBillar.
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1.1, 07 de diciembre de 2022
 */
public final class ConjuntoBolas {
    //PROPIEDADES
    private final ArrayList<Bola> conjunto; // Guarda las Bolas
    private final int cantidadBolas; // Define la cantidad de Bolas que habran en la mesa de billar 
    private final MesaBillar mesaBillar; // Se usa para tener posiciones relativas de las bolas con repecto a la mesa de billar
    private boolean turnoAcabado;
    
    //METODOS
    /**
     * Metodo Getter de la variable que indica el turno. 
     * @return int A que jugador le toca golpear la bolaBlanca.
     */
    public boolean getTurnoAcabado(){
        return turnoAcabado;
    }
    /**
     * Metodo Getter de una bola en el conjunto (no la quita del conjunto).
     * @param numero de Bola se quiere obtener.
     * @return Bola que se obtendra. 
     */
    public Bola getBola(int numero){
        return conjunto.get(numero);
    }
    /**
     * Metodo Getter de un conjunto.
     * @return conjunto ArrayList de Bolas .
     */
    public ArrayList<Bola> getConjunto(){
        return conjunto;
    }
    /**
     * Metodo que detecta si existe alguno Bola que sigue en movimiento.
     * @return true en caso de que se acabe el turno y asigna un valor de 0 al turno, y false en caso de que aun no (Y 0 al valor de turno).
     */
    public boolean TurnoAcabado(){
        for(int i=0 ; i<conjunto.size() ; i++){
            if(conjunto.get(i).getVelocidadX()!=0 || conjunto.get(i).getVelocidadY()!=0){
                turnoAcabado = false;
                return false;
            }
        }
        mesaBillar.cambiaTurno();
        turnoAcabado = true;
        return true;
    }
    /**
     * Metodo que procesa la trayectoria que tedra cada Bola del Conjunto. Mientras en pantalla mostramos un frame, internamente procesa 10 posiciones y sus colisiones.
     */
    public void Movimiento(){
        int ticks = 10;
        for(int j=0 ; j<ticks ; j++){
            for(int i=0 ; i<conjunto.size() ; i++){
                conjunto.get(i).movimientoBola(ticks); 
                for(int k=0 ; k<conjunto.size() ; k++){
                    if(i != k){
                        ColisionDosBolas(conjunto.get(i), conjunto.get(k));
                    }
                }
                if(mesaBillar.bolaCaeTronera(conjunto.get(i)) == false){
                    ColisionPared(conjunto.get(i));
                }
            }
        }
    }
    /**
     * Metodo que detecta si hay una colision entre una Bola y  la Pared de la mesa
     * @param b1 
     */
    public void ColisionPared(Bola b1){
        if(b1.getX()<mesaBillar.getX()){
            b1.setVelocidadX(-b1.getVelocidadX());
            b1.setX(mesaBillar.getX());
        }else if(b1.getX()+30>1064+mesaBillar.getX()){
            b1.setVelocidadX(-b1.getVelocidadX());
            b1.setX(1024+mesaBillar.getX());
        }
        if(b1.getY()<mesaBillar.getY()){
            b1.setVelocidadY(-b1.getVelocidadY());
            b1.setY(mesaBillar.getY());
        }else if(b1.getY()+30>481+mesaBillar.getY()){
            b1.setVelocidadY(-b1.getVelocidadY());
            b1.setY(451+mesaBillar.getY());
        }
    }
    /**
     * Metodo que detecta si hay una colision entre dos Bolas, y luego cambia sus direcciones.
     * @param b1
     * @param b2 
     */
    public void ColisionDosBolas(Bola b1, Bola b2){
        if(DetectarColision(b1, b2)){
            EfectoDeColision(b1, b2);
        }
    }
    /**
     * Metodo que detecta si hay una colision entre dos bolas
     * @param b1
     * @param b2
     * @return Si hay una colisión, devuelve true, en caso contrario, false
     */
    public boolean DetectarColision(Bola b1, Bola b2){
        if(distEntre2Puntos(b1.getX(), b1.getY(), b2.getX(), b2.getY()) < 30){
            return true;
        }
        return false;
    }
    /**
     * Metodo que cambia la dirreccion y sentido con respecto a cada tipo de colision entre dos Bolas
     * @param b1
     * @param b2 
     */
    public void EfectoDeColision(Bola b1, Bola b2){
         // Despegar b1 y b2
         float puntoMedioX = (b1.getX()+b2.getX())/2;
         float puntoMedioY = (b1.getY()+b2.getY())/2;
         float distB1B2 = (float)Math.sqrt(((b1.getX()-b2.getX())*(b1.getX()-b2.getX()))+((b1.getY()-b2.getY())*(b1.getY()-b2.getY())));
         float distX = (b1.getX() - b2.getX()) / (float)distB1B2;
         float distY = (b1.getY() - b2.getY()) / distB1B2;
         b1.setXY(puntoMedioX+16*distX, (float) (puntoMedioY+16*distY));
         b2.setXY(puntoMedioX-16*distX, (float) (puntoMedioY-16*distY));
         
         // Dar nueva direccion a b1 y b2
         float angulo = anguloPI(b1.getX(), b1.getY(), b2.getX(), b2.getY());
         float cos = (float)Math.cos(angulo);
         float sen = (float)-Math.sin(angulo);
         float auxVelX1 = b2.getVelocidadX()*cos + b2.getVelocidadY()*sen;
         float auxVelY1 = - b1.getVelocidadX()*sen + b1.getVelocidadY()*cos;
         float auxVelX2 = b1.getVelocidadX()*cos + b1.getVelocidadY()*sen;
         float auxVelY2 = - b2.getVelocidadX()*sen + b2.getVelocidadY()*cos;
         b1.setVelocidadX(auxVelX1*cos - auxVelY1*sen);
         b1.setVelocidadY(auxVelX1*sen + auxVelY1*cos);
         b2.setVelocidadX(auxVelX2*cos - auxVelY2*sen);
         b2.setVelocidadY(auxVelX2*sen + auxVelY2*cos);
    }
    /**
     * 
     * Metodo que randomiza la posicion de las Bolas
     */
    public void RandomizarBolas(){

        for(int i=0 ; i<conjunto.size() ; i++){
            conjunto.get(i).setXY((float)(Math.random()*1034)+mesaBillar.getX(), (float)(Math.random()*451)+mesaBillar.getY());
            conjunto.get(i).setVelocidadX(0);
            conjunto.get(i).setVelocidadY(0);
        }     
        for(int i=0 ; i<conjunto.size() ; i++){
            for(int j=1 ; j<conjunto.size() ; j++){
                if(((DetectarColision(conjunto.get(i), conjunto.get(j)) == true) && i != j)){
                    boolean aux;
                    do{
                        conjunto.get(i).setXY((float)(Math.random()*1034)+mesaBillar.getX(), (float)(Math.random()*451)+mesaBillar.getY());
                        aux = false;
                            for(int k=0 ; k<conjunto.size() ; k++){
                                if(((DetectarColision(conjunto.get(i), conjunto.get(k)) == true) && i != k )){
                                    aux = true; 
                                }
                            }
                    }while(aux == true);
                }
            }
        }
        for(int i=0 ; i<conjunto.size() ; i++){
            mesaBillar.bolaCaeTronera(conjunto.get(i));
        }
        if(mesaBillar.TroneraVacia() == false){
            mesaBillar.VaciarTronera();
            RandomizarBolas();
        }
    }
    /**
     * Metodo paint de ConjuntoBolas, hace un llamado al paint de cada Bola
     * @param g clase Graphics
     * @param panel clase JPanel 
     */
     public void paint(Graphics g, JPanel panel){
        for(int j = 0; j < conjunto.size() ; j++){
            conjunto.get(j).paint(g, panel);
        }
     }
    /**
     * Metodo Constructor de ConjuntoBolas.
     * @param mesaBillar Referencia  a mesaBillar en que se encuentra. 
     */
    public ConjuntoBolas(MesaBillar mesaBillar){
        this.mesaBillar = mesaBillar;
        conjunto = new ArrayList<>();
        cantidadBolas = 8;
        conjunto.add(new Bola(0, 0, -10, 0));
        for(int i=1 ; i<=cantidadBolas ; i++){
            conjunto.add(new Bola(0, 0, 10, i));
        }
        RandomizarBolas();
        this.turnoAcabado = true;
    } 
}

