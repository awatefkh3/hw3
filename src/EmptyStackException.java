/**
 * Represents an empty stack exception
 */
public class EmptyStackException extends StackException{
    /**
     * a constructor for the exception. thrown if the stack is empty.
     */
    public EmptyStackException(){
        super();
    }

    /**
     * a constructor for the exception that returns a given string. thrown if the stack is empty.
     * @param message - the error message to be returned
     */
    public EmptyStackException(String message){
        super(message);
    }
}
