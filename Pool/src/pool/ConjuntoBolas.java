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
    private boolean DetectarColision(Bola b1, Bola b2){
        double Aux = distEntre2Puntos(b1.getX(), b1.getY(), b2.getX(), b2.getY());
        if(Aux <= 30){
            return true;
        }else{
            return false;
        }
    }
    
    public void ColisionSimple(){
        
    }
    
    public void AnguloColision(){
    }
    
    private void RandomizarBolas(){
        for(int i=0 ; i<conjunto.size() ; i++){
            conjunto.get(i).setXY((int)(Math.random()*1034+100), (int)(Math.random()*451+100));
        }
        for(int i=0 ; i<8; i++){
            for(int j=i+1 ; j<9; j++){
                if(DetectarColision(conjunto.get(i), conjunto.get(j)) == true){
                    System.out.println("aaa");
                    
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
        
        /*
        for(int i = 0; i<9; ++i){
            for(int j = 0; j<9;++j){
                if(c.get(i).DetectarColision(c.get(i), c.get(j)) &&  i != j){
                    System.out.println("aaa");
                    boolean aux = false;        
                    do{
                        c.get(i).setX((int)(Math.random()*1064+100));
                        c.get(i).setY((int)(Math.random()*481+100));
                        aux = false;
                            for(int k = 0; k<9;++k){
                                aux = c.get(i).DetectarColision(c.get(i), c.get(k));
                                if(aux){
                                    break;
                                }
                            }
                    }while(aux == true);
                }
            }
        }*/
    }
}

