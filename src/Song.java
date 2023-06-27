/**
 * Represents a song
 */
public class Song implements Cloneable{
    /** name of the song */
    protected String name;
    /** name of the artist */
    protected String artist;
    /** genre of the song */
    protected Genre genre;
    /** duration of the song */
    protected int duration;

    enum Genre{
        /** enum fields*/
        POP, ROCK, HIP_HOP, COUNTRY, JAZZ, DISCO
    }

    /**
     * constructor with all parameters
     * @param name string name of the song
     * @param artist string artist of the song
     * @param genre genre of the song
     * @param duration int duration of the song
     */
    public Song(String name, String artist, Genre genre, int duration){
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }


    /**
     * creates a copy of the object
     * @return Song - the copy of the object
     */
    @Override
    protected Song clone() {
        try {
            Song temp = (Song) super.clone();
            temp.duration = this.duration;
            temp.artist = this.artist;
            temp.name = this.name;
            temp.genre = this.genre;
            return temp;
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }

    /**
     * checks if this object and the parameter object are equal
     * @param obj the object we want to check
     * @return true if this object and the parameter object are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Song)) return false;
        return this.artist.equals(((Song) obj).artist) && this.duration == ((Song) obj).duration
                && this.name.equals(((Song) obj).name) && this.genre == ((Song) obj).genre;
    }

    /**
     * describes the song and the attributes
     * @return String - describes the song
     */
    @Override
    public String toString() {
        return   name + ", " +
                 artist + ", " +
                 genre + ", " +
                 duration/60 + ':' + String.format("%02d",duration%60);
    }

    /**
     * calculates a hashcode value of this object
     * @return int - hashcode value of this object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for(int i = 0; i < name.length(); i++){
            hash+= (int) name.charAt(i) ;
        }
        for(int i = 0; i < artist.length(); i++){
            hash+= (int) artist.charAt(i);
        }
        return hash;
    }

    /**
     * name getter
     * @return string name of the song
     */
    public String getName() {
        return name;
    }

    /**
     * artist getter
     * @return string artist of the song
     */
    public String getArtist(){
        return artist;
    }

    /**
     * genre getter
     * @return genre of the song
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * duration getter
     * @return int duration of the song
     */
    public int getDuration() {
        return duration;
    }

    /**
     * duration setter
     * @param duration we want to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * genre setter
     * @param genre we want to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
