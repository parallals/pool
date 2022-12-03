package pool;

import static angular.Angular.distEntre2Puntos;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/** 
 * @author Francy Jelvez
 * @author Diego Venegas
 * @version versión  1, 03 de diciembre de 2022
 */
public class MesaBillar {
    //PROPIEDADES
    private final int x; // Posicion con respecto a la horizontal.
    private final int y; // Posicion con respecto a la vertical.
    ConjuntoBolas conjuntoBolas; // Guarda el Conjunto de Bolas.
    private final ArrayList<Bola> enTronera;
    private int Puntaje;
    
    //METODOS
    /**
     * Getter de Bola
     * @return conjuntoBolas
     */
    public Bola getBola(int i){
        return conjuntoBolas.getBola(i);   
    }
    /**
     * Getter de conjuntoBolas
     * @return  conjuntoBolas
     */
    public ConjuntoBolas getConjunto(){
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
     * Verifica si hay bolas que caigan en una tronera
     * @param b1
     */
    public void bolaCaeTronera(Bola b1){
        if((distEntre2Puntos(b1.getX()+15, b1.getY()+15, x-5, y-5) < 35) //Tronera 1
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+(1064/2)-20, y-5) < 35) //Tronera 2
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+1064-40+45, y-5) < 35) //Tronera 3
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x-5, y+501-(40-25)) < 35) //Tronera 4
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+(1064/2), y+501-(40-25)) < 35) //Tronera 5
         || (distEntre2Puntos(b1.getX()+15, b1.getY()+15, x+1064-40+45, y+501-(40-25)) < 35)){ //Tronera 6
            if(b1.getSerie() == 0){
                Puntaje = Puntaje + b1.getPuntaje();
                b1.setVelocidadX(0);
                b1.setVelocidadY(0); 
                b1.setXY((int)((Math.random()*1034)+x), (int)((Math.random()*451)+y));
            }else{
                for(int i=0 ; i<conjuntoBolas.getConjunto().size() ; i++){
                    if(conjuntoBolas.getBola(i).getSerie() == b1.getSerie()){
                        b1.setVelocidadX(0);
                        b1.setVelocidadY(0); 
                        b1.setXY(0, 400);
                        Puntaje = Puntaje + b1.getPuntaje();
                        enTronera.add(conjuntoBolas.getConjunto().remove(i));
                        break;
                    }
                }  
            }
        }
    }   
    /**
     * Metodo que reinicia el puntaje, velocidad y posicion de Bolas .
     */
    public void reiniciarJuego(){
        int aux = enTronera.size();
        for(int i=0 ; i<aux ; i++){
            conjuntoBolas.getConjunto().add(enTronera.remove(0));
        }
        conjuntoBolas.RandomizarBolas();
        Puntaje = 0;
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
        //Puntaje
        g.setFont(new Font("Calibri",Font.PLAIN,20));
        String s = "Puntaje: " + Integer.toString(Puntaje);
        g.drawString(s, 1100, 700);
        //conjuntoBolas
        conjuntoBolas.paint(g, panel);
    }
    /*
    Constructor de MesaBillar
    */
    public MesaBillar(){
        enTronera = new ArrayList<>();
        Puntaje = 0;
        x = 100;
        y = 100;
        conjuntoBolas = new ConjuntoBolas(this);
    }
 
}