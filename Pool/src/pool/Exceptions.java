package pool;

/*______________________________________EXCEPTION______________________________________*/
class Exception extends RuntimeException{
    public Exception(){}
    /**
     * Metodo Constructor Exception
     * @param mensaje 
     */
    public Exception(String mensaje){
        super(mensaje);
    }
}