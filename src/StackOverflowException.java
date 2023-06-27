/**
 * Represents stack overflow exception
 */
public class StackOverflowException extends StackException{
    /**
     * a constructor for the exception. thrown if the stack overflows.
     */
    public StackOverflowException(){
        super();
    }

    /**
     * a constructor for the exception that returns a given string. thrown if the stack overflows.
     * @param message - the error message to be returned
     */
    public StackOverflowException(String message){
        super(message);
    }
}
