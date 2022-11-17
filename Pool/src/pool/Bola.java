package pool;

import java.awt.Graphics;
import javax.swing.JPanel;
import angular.Angular;
import static angular.Angular.distEntre2Puntos;
import java.awt.Color;

public class Bola {
    //PROPIEDADES
    protected int x;
    protected int y;
    protected int velocidadX;
    protected int velocidadY;
    protected boolean estado; // Si esta en la mesa o en una tronera
    protected final int radio;
    protected int puntaje;
    
    //METODOS
    public void paint(Graphics g, JPanel panel){
        switch(puntaje){
            case 1:
                g.setColor(new Color(200, 10, 10));
                break;
            case 2:
                g.setColor(new Color(10, 200, 10));
                break;
            case 3:
                g.setColor(new Color(10, 10, 200)); 
                break;
            case 4:
                g.setColor(new Color(10, 200, 200));
                break;
            case 5:
                g.setColor(new Color(200, 10, 200)); 
                break;
            case 6:
                g.setColor(new Color(200, 200, 10)); 
                break;
            case 7:
                g.setColor(new Color(100, 100, 100)); 
                break;
            case 8:
                g.setColor(new Color(0,0,0));
                break;
            default:
                g.setColor(Color.white);
                break;
        }
        g.fillOval(x, y, 30, 30);
    };
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void ColisionSimple(){
        
    }
    
    public boolean DetectarColision(Bola b1,Bola b2){
        double Aux = distEntre2Puntos(b1.getX()+15, b1.getY()+15, b2.getX()+15, b2.getY()+15);
        if(Aux < 30){
            return true;
        }else{
            return false;
        }
    }
    
    public void AnguloColision(){
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    
    public Bola(int x, int y, int puntaje){
        this.x = x;
        this.y = y;
        velocidadX = 0;
        velocidadY = 0;
        estado = true; // Si esta en la mesa o no
        radio = 15;
        this.puntaje = puntaje;
    }
}