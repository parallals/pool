package pool;

import static angular.Angular.distEntre2Puntos;
import static angular.Angular.anguloPI;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.font.FontRenderContext;
//import java.util.Random;


public class ConjuntoBolas {
    //PROPIEDADES
    private final ArrayList<Bola> conjunto; // Guarda las Bolas
    private final int cantidadBolas; // Define la cantidad de Bolas que habran en la mesa de billar 
    private final MesaBillar mesaBillar; // Se usa para tener posiciones relativas de las bolas con repecto a la mesa de billar
    
    /**
     * Getter de una bola en el conjunto
     * @param i
     * @return 
     */
    public Bola getBola(int i){
        return conjunto.get(i);
    }
    /**
     * Getter de cantidadBolas
     * @return 
     */
    public int getCantidad(){
        return cantidadBolas;
    }
    //METODOS
    /**
     * Getter de bolaBlanca
     * @return bolaBlanca
     */
    public Bola getBolaBlanca(){
        return conjunto.get(0);
    }
    /**
     * Detecta si existe alguno Bola que sigue en movimiento.
     * @return true en caso de que se acabo el turno y false en caso de que aun no.
     */
    public boolean TurnoAcabado(){
        for(int i=0 ; i<conjunto.size() ; i++){
            if(conjunto.get(i).getVelocidadX()!=0 || conjunto.get(i).getVelocidadY()!=0){
                return false;
            }
        }
        return true;
    }
    /**
     * Funcion que procesa la trayectoria que tedra cada Bola del Conjunto
     */
    public void Movimiento(){
        for(int i=0 ; i<conjunto.size() ; i++){
            if(conjunto.get(i).getEstado() == true){
                conjunto.get(i).movimientoBola();    
            }
        }
        for(int i=0 ; i<conjunto.size() ; i++){
            if(conjunto.get(i).getEstado() == true){
                ColisionPared(conjunto.get(i));
            }
        }
        for(int i=0 ; i<conjunto.size()-1 ; i++){
            for(int j=i+1 ; j<conjunto.size() ; j++){
                ColisionBolas(conjunto.get(i), conjunto.get(j));
            }
        }
        mesaBillar.bolaCaeTronera();
        
    }
    /**
     * Detecta si hay una colision entre una Bola y  la Pared de la mesa
     * @param b1 
     */
    public void ColisionPared(Bola b1){
        if(b1.getX()<mesaBillar.getX() && b1.getVelocidadX()<0){
            b1.setVelocidadX(-b1.getVelocidadX());
            b1.setX(mesaBillar.getX());
        }else if(b1.getX()+30>1064+mesaBillar.getX() && b1.getVelocidadX()>0){
            b1.setVelocidadX(-b1.getVelocidadX());
            b1.setX(1024+mesaBillar.getX());
        }
        if((b1.getY()<mesaBillar.getY() && b1.getVelocidadY()<0)){
            b1.setVelocidadY(-b1.getVelocidadY());
            b1.setY(mesaBillar.getY());
        }else if(b1.getY()+30>481+mesaBillar.getY() && b1.getVelocidadY()>0){
            b1.setVelocidadY(-b1.getVelocidadY());
            b1.setY(451+mesaBillar.getY());
        }
    }
    /**
     * Detecta si hay una colision entre dos Bolas, y luego cambia sus direcciones.
     * @param b1
     * @param b2 
     */
    public void ColisionBolas(Bola b1, Bola b2){
        if(DetectarColision(b1, b2)){
            AnguloColision(b1, b2);
        }
    }
    
    /**
     * Detecta si hay una colision entre dos bolas
     * @param b1
     * @param b2
     * @return Si hay una colisión, devuelve true, en caso contrario, false
     */
    public boolean DetectarColision(Bola b1, Bola b2){
        if(b1.getEstado()==true && b2.getEstado()==true){
            double Aux = distEntre2Puntos(b1.getX(), b1.getY(), b2.getX(), b2.getY());
            if(Aux <= 30){
                return true;
            }
        }
        return false;
    }
    /**
     * Funcion que suma el puntaje de toda bola en caso que caiga en una tronera
     * @return sumatoria de los puntos
     */
    public int recibirPuntaje(){
        int Sumapuntos = 0;
        for(int i = 0; i<cantidadBolas;++i){
            if(conjunto.get(i).getEstado()== false){
                Sumapuntos = conjunto.get(i).getPuntaje() + Sumapuntos;
            }
        }
        return Sumapuntos;
    }    
    /**
     * Cambia la dirreccion y sentido con respecto a cada tipo de colision entre dos Bolas
     * @param b1
     * @param b2 
     */    
    public void AnguloColision(Bola b1, Bola b2){
         float angle = anguloPI(new Point((int)b1.getX(), (int)b1.getY()),new Point((int)b2.getX(), (int)b2.getY()));
         double cos = Math.cos(angle);
         double sen = Math.sin(angle);
         double velocidadTotal1 = Math.sqrt(b1.getVelocidadX()*b1.getVelocidadX() + b1.getVelocidadY()*b1.getVelocidadY());
         double velocidadTotal2 = Math.sqrt(b2.getVelocidadX()*b2.getVelocidadX() + b2.getVelocidadY()*b2.getVelocidadY());
         
         if(b1.getX() > b2.getX()){
             b1.setVelocidadX(velocidadTotal2*cos);
             b2.setVelocidadX(velocidadTotal1*cos);
         }else if(b1.getX() < b2.getX()){
             b1.setVelocidadX(velocidadTotal2*cos);
             b2.setVelocidadX(-velocidadTotal1*cos);
         }else{/*
             Aux = b1.getVelocidadX();
             b1.setVelocidadX(b2.getVelocidadX());
             b2.setVelocidadX(Aux);*/
         }
         
         if(b1.getY() > b2.getY()){
             b1.setVelocidadY(velocidadTotal2*sen);
             b2.setVelocidadY(-velocidadTotal1*sen);
             
         }else if(b1.getY() < b2.getY()){
             b1.setVelocidadY(velocidadTotal2*sen);
             b2.setVelocidadY(-velocidadTotal1*sen);
             
         }else{/*
             Aux = b1.getVelocidadY();
             b1.setVelocidadY(b2.getVelocidadY());
             b2.setVelocidadY(Aux);*/
         }
    }
    /**
     * Randomiza la posicion de las Bolas
     */
    private void RandomizarBolas(){
        for(int i=0 ; i<conjunto.size() ; i++){
            conjunto.get(i).setXY((int)((Math.random()*1034)+mesaBillar.getX()), (int)((Math.random()*451)+mesaBillar.getY()));
            conjunto.get(i).setEstado(true);
        }
        for(int i=0 ; i<conjunto.size() ; i++){
            for(int j=1 ; j<conjunto.size() ; j++){
                if((DetectarColision(conjunto.get(i), conjunto.get(j)) == true) && i != j){
                    System.out.println("Detectada colision");
                    boolean aux;
                    do{
                        conjunto.get(i).setXY((int)((Math.random()*1034)+mesaBillar.getX()), (int)((Math.random()*451)+mesaBillar.getY()));
                        aux = false;
                            for(int k=0 ; k<conjunto.size() ; k++){
                                if((DetectarColision(conjunto.get(i), conjunto.get(k)) == true) && i != k){
                                    System.out.println("Detectada colision luego del randomizer");
                                    aux = true; 
                                }
                            }
                    }while(aux == true);
                }
            }
        }
    }
    /**
     * Funcion paint de ConjuntoBolas, hace un llamado al paint de cada Bola
     * @param g
     * @param panel 
     */
     public void paint(Graphics g, JPanel panel){
        for(int j = 0; j < conjunto.size() ; j++){
            if(conjunto.get(j).getEstado() == true){
                conjunto.get(j).paint(g, panel);
            }
        }        
        Font f = new Font("Calibri",Font.PLAIN,20);
        g.setFont(f);
        String s = "Puntaje: " + Integer.toString(recibirPuntaje());
        g.drawString(s, 1100, 700);
     }
    /**
     * Constructor de ConjuntoBolas
     * @param mesa 
     */
    public ConjuntoBolas(MesaBillar mesa){
        mesaBillar = mesa;
        conjunto = new ArrayList<>();
        cantidadBolas = 8;
        conjunto.add(new Bola(0, 0, -10, 0));
        for(int i=1 ; i<=cantidadBolas ; i++){
            conjunto.add(new Bola(0, 0, 10, i));
        }
        RandomizarBolas();
    }
}

