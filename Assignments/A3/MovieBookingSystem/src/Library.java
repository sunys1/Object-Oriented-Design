public class Library {
    private MovieManager manager;

    public Library() {
        manager = new MovieManager();
    }

    public void addMovie(Movie movie) {
        manager.addResource(movie);
    }

    public void addShowToMovie(Movie movie, Show show) {
        manager.addShowToMovie(show);
    }

    public void previewSeat(Movie movie, Show show) {
        manager.printSeatMap(show);
    }

    public Booking createBooking(Movie movie, User user, int numTickets) {
        return manager.book(movie, user, numTickets);
    }

    public void cancelBooking (Booking booking) {
        manager.release(booking);
    }
}
