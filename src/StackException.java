/**
 * Represents a stack exception
 */
public class StackException extends RuntimeException{
    /**
     * a constructor for the exception. thrown if there is an exception in regard to the stack.
     */
    public StackException(){
        super();
    }

    /**
     * a constructor for the exception that returns a given string. thrown if there is an exception in regard to the stack.
     * @param message - the error message to be returned
     */
    public StackException(String message){
        super(message);
    }

}
