package pool;

/*______________________________________EXCEPTION______________________________________*/
class Exception extends RuntimeException{
    public Exception(){}
    /**
     * Constructor Exception
     * @param mensaje 
     */
    public Exception(String mensaje){
        super(mensaje);
    }
}