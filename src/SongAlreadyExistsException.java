public class SongAlreadyExistsException extends RuntimeException{
    public SongAlreadyExistsException(){
        super();
    }

    public SongAlreadyExistsException(String message){
        super(message);
    }
}
