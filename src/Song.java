public class Song {

    protected String name;
    protected String artist;
    protected Genre genre;
    protected int duration;

    enum Genre{
        POP, ROCK, HIP_HOP, COUNTRY, JAZZ, DISCO
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
        return "(" +
                 name + ", " +
                 artist + ", " +
                 genre + ", " +
                 duration/60 + ':' + duration%60 +
                ')';
    }
}
