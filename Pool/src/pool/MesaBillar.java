package pool;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class MesaBillar {
    //PROPIEDADES
    private final int x; // Posicion con respecto a la horizontal.
    private final int y; // Posicion con respecto a la vertical.
    ConjuntoBolas conjuntoBolas; // Guarda el Conjunto de Bolas.
    
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
     * Paint de MesaBillar, hace un llamado a ConjuntoBolas
     * @param g
     * @param panel 
     */
    public void paint(Graphics g, JPanel panel){
        //Mesa
        g.setColor(new Color(100, 60, 50)); 
        g.fillRect(x-30, y-30, 1064+60, 481+60);
        g.setColor(new Color(30, 130, 80)); // Zona Verde
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