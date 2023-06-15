import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist {
    ArrayList<Song> playlist = new ArrayList<Song>();
    public void addSong(Song s) throws SongAlreadyExistsException{
        boolean song_in_playlist = false;
        for(Song song: this.playlist){
            if(song.equals(s) && !song_in_playlist)
                song_in_playlist = true;
        }
        if(!song_in_playlist){
            this.playlist.add(s);
        }
        else{
            throw new SongAlreadyExistsException();
        }
    }

    public boolean removeSong(Song s){
        for(Song song: this.playlist){
            if(song.equals(s)){
                playlist.remove(song);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "[";
        for(Song s: this.playlist){
            if(s.equals(this.playlist.get(this.playlist.size()-1))){
                str += s.toString();
            }
            else{
                str += s.toString() +", ";
            }
        }
        return str + "]";
    }
}
