public class Song implements Cloneable{

    protected String name;
    protected String artist;
    protected Genre genre;
    protected int duration;

    enum Genre{
        POP, ROCK, HIP_HOP, COUNTRY, JAZZ, DISCO
    }

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

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Song)) return false;
        return this.artist.equals(((Song) obj).artist) && this.duration == ((Song) obj).duration
                && this.name.equals(((Song) obj).name) && this.genre == ((Song) obj).genre;
    }

    @Override
    public String toString() {
        return   name + ", " +
                 artist + ", " +
                 genre + ", " +
                 duration/60 + ':' + String.format("%02d",duration%60);
    }

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

    public String getName() {
        return name;
    }

    public String getArtist(){
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
