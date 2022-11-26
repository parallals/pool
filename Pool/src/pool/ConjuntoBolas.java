package pool;

//import java.util.Random;
import static angular.Angular.distEntre2Puntos;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class ConjuntoBolas {
    //PROPIEDADES
    
    private final ArrayList<Bola> conjunto;
    private int cantidadBolas;
    private MesaBillar mesaBillar;
    
    //METODOS
    /**
     * Getter de conjunto
     * @return conjunto
     */
    public ArrayList<Bola> getConjunto(){
        return conjunto;
    }
    
    public void Movimiento(){
        for(int i=0 ; i<conjunto.size() ; i++){
            conjunto.get(i).movimientoBola();
        }
        for(int i=0 ; i<conjunto.size() ; i++){
            ColisionPared(conjunto.get(i));
        }
        for(int i=0 ; i<conjunto.size()-1 ; i++){
            for(int j=i+1 ; j<conjunto.size() ; j++){
                ColisionBolas(conjunto.get(i), conjunto.get(j));
            }
        }
    }
    /**
     * Detecta si hay una colision entre una bola y  la pared de la mesa
     * @param b1 
     */
    public void ColisionPared(Bola b1){ //Colision entre Bola Pared
        if(b1.getEstado()==true){
            if((b1.getX()<mesaBillar.getX() && b1.getVelocidadX()<0) || (b1.getX()+30>1064+mesaBillar.getX() && b1.getVelocidadX()>0)){
                b1.setVelocidadX(-b1.getVelocidadX());
            }
            if((b1.getY()<mesaBillar.getY() && b1.getVelocidadY()<0) || (b1.getY()+30>481+mesaBillar.getY() && b1.getVelocidadY()>0)){
                b1.setVelocidadY(-b1.getVelocidadY());
            }
        }
    }
    /**
     * Detecta si hay una colision entre una bola y otra, y guarda el angulo de colision
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
     * @return Si hay una colisión, devuelve true.
     */
    public boolean DetectarColision(Bola b1, Bola b2){ //Colision entre dos Bolas
        if(b1.getEstado()==true && b2.getEstado()==true){
            double Aux = distEntre2Puntos(b1.getX(), b1.getY(), b2.getX(), b2.getY());
            if(Aux <= 30){
                return true;
            }
        }
        return false;
    }
    /**
     * Detecta y registra el angulo de colision
     * @param b1
     * @param b2 
     */
    public void AnguloColision(Bola b1, Bola b2){
        
    }
    /**
     * Randomiza la posicion de las bolas
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
     * Funcion paint de ConjuntoBolas
     * @param g
     * @param panel 
     */
     public void paint(Graphics g, JPanel panel){
        for(int j = 0; j < conjunto.size() ; j++){
            if(conjunto.get(j).getEstado() == true){
                conjunto.get(j).paint(g, panel);
            }
        }
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
        conjunto.get(0).setVelocidadX(20);
        conjunto.get(0).setVelocidadY(20);
    }
}

