package pool;
import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class ConjuntoBolas {
    //PROPIEDADES
    private final ArrayList<Bola> c;
    //private final BolaBlanca bb;
    private final Bola b1,b2,b3,b4,b5,b6,b7,b8,bb;
    /*private final Bola2 b2;
    private final Bola3 b3;
    private final Bola4 b4;
    private final Bola5 b5;
    private final Bola6 b6;
    private final Bola7 b7;
    private final Bola8 b8;*/
    
    //METODOS
     public void paint(Graphics g, JPanel panel){
        for(int j = 0; j < c.size() ; j++){
            if(c.get(j).estado == true){
                c.get(j).paint(g, panel);
            }
        }
     }
        
    public ConjuntoBolas(){
        c = new ArrayList<>();
        bb = new Bola(200, 100,0);
        c.add(bb);
        b1 = new Bola((int)(Math.random()*1024+100),(int)(Math.random()*441+100),1);
        c.add(b1);
        b2 = new Bola((int)(Math.random()*1024+100),(int)(Math.random()*441+100),2);
        c.add(b2);
        b3 = new Bola((int)(Math.random()*1024+100),(int)(Math.random()*441+100),3);
        c.add(b3);
        b4 = new Bola((int)(Math.random()*1024+100),(int)(Math.random()*441+100),4);
        c.add(b4);
        b5 = new Bola((int)(Math.random()*1024+100),(int)(Math.random()*441+100),5);
        c.add(b5);
        b6 = new Bola((int)(Math.random()*1024+100),(int)(Math.random()*441+100),6);
        c.add(b6);
        b7 = new Bola(100,100,7);
        c.add(b7);
        b8 = new Bola(100,100,8);
        c.add(b8);
        
        for(int i = 0; i<9; ++i){
            for(int j = 0; j<9;++j){
                if(c.get(i).DetectarColision(c.get(i), c.get(j))&& i != j){
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
        }
    }
}

