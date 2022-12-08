package angular;


public class Angular {
    /**
     * Metodo que calcula el angulo respecto a la horizontal
     * @param uno: punto de referencia
     * @param dos: otro punto
     * @return double el ángulo con respecto a la horizontal
     */
    public static float anguloPI(float x1, float y1, float x2, float y2){    
        float alto = y2-y1;
        float ancho = x2-x1;
        float angulo = (float)Math.atan2(-alto,ancho);      
        return angulo; //sin radianes
    }
    /**
     * Metodo que da la distancia entre dos puntos
     * @param x1 Coordenada x del punto 1
     * @param y1 Coordenada y del punto 1
     * @param x2 Coordenada x del punto 2
     * @param y2 Coordenada y del punto 2
     * @return double distancia
     */
    public static float distEntre2Puntos(float x1, float y1, float x2, float y2){ 
        float d = (float)Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)* (y1-y2)));
        return d;
    }
}