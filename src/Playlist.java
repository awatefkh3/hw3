import java.util.*;

/**
 * Represent a playlist of songs
 */
public class Playlist implements FilteredSongIterable, OrderedSongIterable, Cloneable{
    /** playlist list */
    ArrayList<Song> list = new ArrayList<Song>();
    /** temporary playlist */
    Playlist tempPlaylist = this.clone();

    /**
     * adds a song to the playlist list
     * @param s the song we want to add
     * @throws SongAlreadyExistsException when trying to add an existing song
     */
    public void addSong(Song s) throws SongAlreadyExistsException{
        boolean song_in_playlist = false;
        for(Song song: this.list){
            if(song.equals(s) && !song_in_playlist)
                song_in_playlist = true;
        }
        if(!song_in_playlist){
            this.list.add(s);
            this.tempPlaylist.list.add(s);
        }
        else{
            throw new SongAlreadyExistsException();
        }
    }

    /**
     * removes a song from the playlist list
     * @param s the song we want to remove
     * @return true if the song is in the playlist, false otherwise
     */
    public boolean removeSong(Song s){
        for(Song song: this.list){
            if(song.equals(s)){
                list.remove(song);
                this.tempPlaylist.list.remove(song);
                return true;
            }
        }
        return false;
    }

    /**
     * describes the playlist and the songs in it
     * @return String - describes the playlist
     */
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
