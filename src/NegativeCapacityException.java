public class NegativeCapacityException extends StackException{
    /**
     * a constructor for the exception. thrown if the capacity given to a stack is negative.
     */
    public NegativeCapacityException(){
        super();
    }

    /**
     * a constructor for the exception that returns a given string. thrown if the capacity given to a stack is negative.
     * @param message - the error message to be returned
     */
    public NegativeCapacityException(String message){
        super(message);
    }
}
