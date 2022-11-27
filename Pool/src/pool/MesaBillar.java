package pool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MesaBillar {
    //PROPIEDADES
    private final int x;
    private final int y;
    ConjuntoBolas conjuntoBolas;
    
    //METODOS
    /**
     * Getter de conjuntoBolas
     * @return conjuntoBolas
     */
    public ConjuntoBolas getCb(){
        return conjuntoBolas;
    }
    /**
     * Getter de X
     * @return x
     */
    public int getX(){
        return x;
    }
    /**
     * Getter de y
     * @return y
     */
    public int getY(){
        return y;
    }
    
    /**
     * Paint de la mesa de billar con posiciones relativas
     * @param g
     * @param panel 
     */
    public void paint(Graphics g, JPanel panel){
        //Mesa
        g.setColor(new Color(100, 60, 50)); 
        g.fillRect(x-30, y-30, 1064+60, 481+60);
        g.setColor(new Color(30, 130, 80)); //Zona Verde
        g.fillRect(x, y, 1064, 481);
        //Troneras
        g.setColor(new Color(0, 0, 0)); 
        g.fillOval(x-25, y-25, 40, 40);
        g.fillOval(x+(1064/2)-40/2, y-25, 40, 40);
        g.fillOval(x+1064-40+25, y-25, 40, 40);
        g.fillOval(x-25, y+481-(40-25), 40, 40);
        g.fillOval(x+(1064/2)-40/2, y+481-(40-25), 40, 40);
        g.fillOval(x+1064-40+25, y+481-(40-25), 40, 40);
        
        conjuntoBolas.paint(g, panel);
        //
    }
    /*
    Constructor de MesaBillar
    */
    public MesaBillar(){
        x = 100;
        y = 100;
        conjuntoBolas = new ConjuntoBolas(this);
    }
 
}
//< w = 1264  y  h = 681 >