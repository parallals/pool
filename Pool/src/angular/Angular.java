package angular;


public class Angular {
    /**
     * Calcula el angulo respecto a la horizontal
     * @param uno: punto de referencia
     * @param dos: otro punto
     * @return double el ángulo con respecto a la horizontal
     */
    public static double anguloPI(double x1, double y1, double x2, double y2){
        double angulo,alto,ancho;       
        alto = y2-y1;
        ancho = x2-x1;
        angulo = Math.atan2(-alto,ancho);      
        return angulo; //sin radianes
    }
    /**
     * Distancia en pixeles entre dos puntos
     * @param x1 Coordenada x del punto 1
     * @param y1 Coordenada y del punto 1
     * @param x2 Coordenada x del punto 2
     * @param y2 Coordenada y del punto 2
     * @return double distancia
     */
    public static double distEntre2Puntos(double x1, double y1, double x2, double y2){ 
        double d = Math.sqrt(
               (((double)x1-(double)x2)*
               ((double)x1-(double)x2))+
               (((double)y1-(double)y2)* 
               ((double)y1-(double)y2))
            );
        return d;
    }
}