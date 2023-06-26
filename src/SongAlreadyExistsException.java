public class SongAlreadyExistsException extends RuntimeException{
    /**
     * a constructor for the exception. thrown if the song given is already in the playlist.
     */
    public SongAlreadyExistsException(){
        super();
    }

    /**
     * a constructor for the exception that returns a given string. thrown if the song given is already in the playlist.
     * @param message - the error message to be returned
     */
    public SongAlreadyExistsException(String message){
        super(message);
    }
}
