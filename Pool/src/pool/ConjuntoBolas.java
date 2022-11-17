package pool;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class ConjuntoBolas {
    //PROPIEDADES
    private final ArrayList<Bola> c;
    private final BolaBlanca bb;
    private final Bola1 b1;
    private final Bola2 b2;
    private final Bola3 b3;
    private final Bola4 b4;
    private final Bola5 b5;
    private final Bola6 b6;
    private final Bola7 b7;
    private final Bola8 b8;
    
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
        bb = new BolaBlanca(200, 100);
        c.add(bb);
        b1 = new Bola1(200, 200);
        c.add(b1);
        b2 = new Bola2(200, 300);
        c.add(b2);
        b3 = new Bola3(200, 400);
        c.add(b3);
        b4 = new Bola4(300, 100);
        c.add(b4);
        b5 = new Bola5(300, 200);
        c.add(b5);
        b6 = new Bola6(300, 300);
        c.add(b6);
        b7 = new Bola7(300, 400);
        c.add(b7);
        b8 = new Bola8(400, 100);
        c.add(b8);
    }
}

