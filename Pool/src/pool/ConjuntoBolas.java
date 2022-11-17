package pool;

//import java.util.Random;
import static angular.Angular.distEntre2Puntos;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class ConjuntoBolas {
    //PROPIEDADES
    private final ArrayList<Bola> conjunto;
    
    //METODOS
    public void ColisionSimple(Bola b1){ //Colision entre Bola Pared
        if(b1.getEstado()==true){
            if((b1.getX()<100 && b1.getVelocidadX()<0) || (b1.getX()+30>1164 && b1.getVelocidadX()>0)){
                b1.setVelocidadX(-b1.getVelocidadX());
            }
            if((b1.getY()<100 && b1.getVelocidadY()<0) || (b1.getY()+30>581 && b1.getVelocidadY()>0)){
                b1.setVelocidadY(-b1.getVelocidadY());
            }
        }
    }
    
    public void ColisionBolas(Bola b1, Bola b2){
        if(DetectarColision(b1, b2)){
            AnguloColision(b1, b2);
        }
    }
    
    private boolean DetectarColision(Bola b1, Bola b2){ //Colision entre dos Bolas
        if(b1.getEstado()==true && b2.getEstado()==true){
            double Aux = distEntre2Puntos(b1.getX(), b1.getY(), b2.getX(), b2.getY());
            if(Aux <= 30){
                return true;
            }
        }
        return false;
    }
    
    public void AnguloColision(Bola b1, Bola b2){
    }
    
    private void RandomizarBolas(){
        for(int i=0 ; i<conjunto.size() ; i++){
            conjunto.get(i).setXY((int)(Math.random()*1034+100), (int)(Math.random()*451+100));
            conjunto.get(i).estado = true;
        }
        for(int i=0 ; i<9; i++){
            for(int j=0 ; j<9; j++){
                if((DetectarColision(conjunto.get(i), conjunto.get(j)) == true) && i != j){
                    System.out.println("Detectada colision en el primer randomizer");
                    boolean aux;
                    do{
                        conjunto.get(i).setXY((int)(Math.random()*1034+100), (int)(Math.random()*451+100));
                        aux = false;
                            for(int k=0; k<9; k++){
                                if((DetectarColision(conjunto.get(i), conjunto.get(k)) == true) && i != k){
                                    System.out.println("Detectada colision en el segundo randomizer");
                                    aux = true; 
                                }
                            }
                    }while(aux == true);
                }
            }
        }
    }
    
     public void paint(Graphics g, JPanel panel){
        for(int j = 0; j < conjunto.size() ; j++){
            if(conjunto.get(j).estado == true){
                conjunto.get(j).paint(g, panel);
            }
        }
     }
        
    public ConjuntoBolas(){
        conjunto = new ArrayList<>();
        conjunto.add(new BolaBlanca(0, 0));
        conjunto.add(new Bola1(0, 0));
        conjunto.add(new Bola2(0, 0));
        conjunto.add(new Bola3(0, 0));
        conjunto.add(new Bola4(0, 0));
        conjunto.add(new Bola5(0, 0));
        conjunto.add(new Bola6(0, 0));
        conjunto.add(new Bola7(0, 0));
        conjunto.add(new Bola8(0, 0));
        RandomizarBolas();
    }
}

