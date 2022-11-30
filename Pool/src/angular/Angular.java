package angular;

import java.awt.Point;


public class Angular {

    /**
     * Obtiene un nuevo punto a una cierta distancia y angulo desde la horizontal
     * @param uno: punto actual
     * @param r: radio en pixeles
     * @param alfaGiro: angulo desde la horizontal en PI radianes
     * @return int punto nuevo
     */
    public  static Point generaPunto(Point uno, double r, double alfaGiro){    
        int x = (int)((double) uno.x + r*Math.cos(alfaGiro*Math.PI));
        int y = (int)((double) uno.y - r*Math.sin(alfaGiro*Math.PI)); 
        Point p = new Point(x, y);
        return p;
    }

    /**
     * Calcula el angulo respecto a la horizontal
     * @param uno: punto de referencia
     * @param dos: otro punto
     * @return int el ángulo con respecto a la horizontal
     */
    // ORIGINAL 
    public static double anguloPI(Point uno, Point dos){
        float angulo,alto,ancho;       
        alto=dos.y-uno.y;
        ancho=dos.x-uno.x;
        angulo = (float)Math.atan2(-(double)alto,(double)ancho);      
        return angulo; //sin radianes
    }
    public static float anguloPI(float uno, float dos){
        float angulo,alto,ancho;       
        alto=dos-uno;
        ancho=dos-uno;
        angulo = (float)Math.atan2(-(double)alto,(double)ancho);      
        return angulo/(float)Math.PI;
    }   
    /**
     * Distancia en pixeles entre dos puntos
     * @param x1 Coordenada x del punto 1
     * @param y1 Coordenada y del punto 1
     * @param x2 Coordenada x del punto 2
     * @param y2 Coordenada y del punto 2
     * @return double distancia
     */
    public static double distEntre2Puntos(double x1, double y1, double x2, double y2){ // Cambiamos los int por double
        double d = Math.sqrt(
               (((double)x1-(double)x2)*
               ((double)x1-(double)x2))+
               (((double)y1-(double)y2)* 
               ((double)y1-(double)y2))
            );
        return d;
    }

    /**
     * Calcula la distancia en pixeles entre dos puntos
     * @param uno Variable tipo Point 1
     * @param dos Variable tipo Point 2
     * @return la distancia
     */
    public static double distEntre2Puntos(Point uno, Point dos){
        double d=Math.sqrt(
               ((double)uno.x-(double)dos.x)*
               ((double)uno.x-(double)dos.x)+
               ((double)uno.y-(double)dos.y)* 
               ((double)uno.y-(double)dos.y)
            );
        return d;
    }
}    