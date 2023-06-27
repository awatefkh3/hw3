/**
 * Represents iterable of filtered songs
 */
public interface FilteredSongIterable extends Iterable<Song> {
    /**
     * filters by artist - keeps the songs that has the same genre as the parameter artist
     * @param artist the artist that we use as a filter
     */
    public void filterArtist(String artist);

    /**
     * filters by genre - keeps the songs that has the same genre as the parameter artist
     * @param genre the genre that we use as a filter
     */
    public void filterGenre(Song.Genre genre);

    /**
     * filters by duration - keeps the songs that has less or equal duration than the parameter duration
     * @param duration the duration that we use as a filter
     */
    public void filterDuration(int duration);

}
