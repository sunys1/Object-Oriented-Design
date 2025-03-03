import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Movie m1 = new Movie("M1", "Movie 1", 10, "Action", "Director 1", "PG-13", "English", "120 mins");
        Movie m2 = new Movie("M2", "Movie 2", 10, "Comedy", "Director 2", "PG-13", "English", "120 mins");

        Show s1 = new Show(1, LocalDateTime.now(), "Location 1", m1, 10.0, 5, ShowStatus.OPEN);
        Show s2 = new Show(2, LocalDateTime.now(), "Location 2", m1, 10.0, 5, ShowStatus.OPEN);
        Show s3 = new Show(3, LocalDateTime.now(), "Location 3", m2, 10.0, 5, ShowStatus.OPEN);

        User u1 = new User(1, "John Doe", PaymentMethod.CREDIT_CARD);
        User u2 = new User(2, "Jane Doe", PaymentMethod.DEBIT_CARD);

        library.addMovie(m1);
        library.addShowToMovie(m1, s1);
        library.addShowToMovie(m1, s2);
        library.addShowToMovie(m2, s3);

        Booking b1 = library.createBooking(m1, u1, 1);
        // Check update seat status
        Booking b2 = library.createBooking(m1, u2, 1);
        library.cancelBooking(b1);
        // b1 seat should be released
        Booking b3 = library.createBooking(m1, u1, 1);
        // Check update show status when seats are sold out
        Booking b4 = library.createBooking(m2, u1, 5);
        // Check re-open sold-out show when there are available seats
        Booking b5 = library.createBooking(m2, u2, 1);
        library.cancelBooking(b4);
        Booking b6 = library.createBooking(m2, u2, 1);
    }
}
