import java.util.*;

public class Playlist implements FilteredSongIterable, OrderedSongIterable, Cloneable{
    ArrayList<Song> list = new ArrayList<Song>();
    
    public void addSong(Song s) throws SongAlreadyExistsException{
        boolean song_in_playlist = false;
        for(Song song: this.list){
            if(song.equals(s) && !song_in_playlist)
                song_in_playlist = true;
        }
        if(!song_in_playlist){
            this.list.add(s);
        }
        else{
            throw new SongAlreadyExistsException();
        }
    }

    public boolean removeSong(Song s){
        for(Song song: this.list){
            if(song.equals(s)){
                list.remove(song);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "[";
        for(Song s: this.list){
            str += "(";
            if(s.equals(this.list.get(this.list.size()-1))){
                str += s.toString() + ")";
            }
            else{
                str += s.toString() +"), ";
            }

        }
        return str + "]";
    }
}
