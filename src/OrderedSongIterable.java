public interface OrderedSongIterable extends Iterable<Song> {
        /**
         * sets the scanning order
         * @param scanningOrder the wanted scanning order
         */
        public void setScanningOrder(ScanningOrder scanningOrder);
}
