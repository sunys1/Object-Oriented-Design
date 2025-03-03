import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

// Since other resource like books, CDs, magazines, etc, do not differ much
// in their implementation, we can use a generic ResourceManager to manage them to avoid code duplication.
// MovieManager is a specialization of ResourceManager for Movies because it has additional functionality
// that is specific to Movies.

public class MovieManager extends ResourceManager<Movie> {
    private ShowRegister register;

    public MovieManager() {
        super();
        register = new ShowRegister();
    }
    public List<Movie> getMovies() {
        return resources.values().stream()
                .filter(resource -> resource instanceof Movie) // Filter only Movie objects
                .map(resource -> (Movie) resource) // Cast to Movie
                .collect(Collectors.toList()); // Collect as List
    }

    public void addShowToMovie(Show show) {
        register.addShow(show);
    }

    // Seat preview
    public void printSeatMap(Show show){
        List<Seat> seats = register.getShowSeats(show.getShowId());

        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public void printAvailableSeats(Show show){
        List<Seat> availableSeats = register.getAvailableShowSeats(show.getShowId());

        for (int i = 0; i < availableSeats.size(); i++) {
            System.out.println((i + 1) + ". " + availableSeats.get(i));
        }
    }

    public Booking book(Movie movie, User user, int numTickets) {
        Booking booking = null;
        Scanner scanner = new Scanner(System.in);

        // Show Selection
        System.out.println("Shows for '" + movie.getName() + "':");
        List<Show> availableShows = register.getAvailableShows(movie.getId());

        if (availableShows.isEmpty()) {
            System.out.println("No shows available for the movie.\n");
            return null;
        }

        for (int i = 0; i < availableShows.size(); i++) {
            System.out.println((i + 1) + ". " + availableShows.get(i));
            System.out.println();
        }

        System.out.println("Please select a show: ");
        int showIndex = scanner.nextInt() - 1;

        // Seat Selection
        if (showIndex >= 0 && showIndex < availableShows.size()) {
            Show show = availableShows.get(showIndex);

            // Verify ticket availability
            if (numTickets <= register.getAvailableShowSeats(show.getShowId()).size()){
                int counter = 0;
                // Create a booking
                booking = new Booking(getNewId(), user, show, numTickets, null);

                while(counter < numTickets){
                    System.out.println("Seat Selection for Ticket " + (counter+1) + ": ");
                    printAvailableSeats(show);
                    int seatIndex = scanner.nextInt() - 1;

                    if (seatIndex >= 0 && seatIndex < register.getAvailableShowSeats(show.getShowId()).size()) {
                        Seat seat = register.getAvailableShowSeats(show.getShowId()).get(seatIndex);

                        // Avoid concurrent modification
                        synchronized (seat) {
                            // Update seat status
                            seat.setStatus(SeatStatus.OCCUPIED);
                            booking.getSeats().add(seat);
                        }
                        counter++;
                    }
                    System.out.println();
                }

                // Process Payment
                processPayment(booking, user);
                booking.setStatus(BookingStatus.CONFIRMED);

                // Check if show is sold out
                if (register.getAvailableShowSeats(show.getShowId()).isEmpty()) {
                    show.setStatus(ShowStatus.SOLD_OUT);
                }
            }else {
                System.out.println("Sorry, there are not enough seats available for the selected show.");
            }


        }

        if (booking != null) {
            System.out.println("Booking successful! Your booking details: \n" + booking);
        }
        return booking;
    }

    public void processPayment(Booking booking, User user) {
        String paymentId = getNewId();
        Payment payment = new Payment(paymentId, user.getPaymentMethod(), LocalDateTime.now(),
                booking.getTotalTickets() * booking.getShow().getPrice());

        payment.setStatus(PaymentStatus.SUCCESS);
        booking.setPayment(payment);
    }

    public void refund(Booking booking) {
        booking.setStatus(BookingStatus.CANCELLED);
        booking.getPayment().setStatus(PaymentStatus.REFUNDED);
        System.out.println("Booking " + booking.getBookingId()
                + " has been cancelled. Refund will be issued to your original payment method.\n");
    }

    // String ID generator for payment and booking
    public String getNewId() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();

        // Generate a 6-character ID
        for (int i = 0; i < 6; i++) {
            // Randomly select a letter from A-Z
            char randomChar = (char) ('A' + random.nextInt(26));
            id.append(randomChar);
        }

        return id.toString();
    }

    // For booking cancellation
    public void release(Booking booking) {
        Show show = booking.getShow();

        // Check if valid for release
        if (booking.getStatus() == BookingStatus.CONFIRMED) {
            if(show.getStatus() != ShowStatus.CLOSED){
                // Reset seat status
                for (Seat seat : booking.getSeats()){
                    register.updateSeatStatus(show.getShowId(), seat.getSeatId(), SeatStatus.AVAILABLE);
                }

                // Reset show status if the show was sold out
                if (show.getStatus() == ShowStatus.SOLD_OUT) {
                    show.setStatus(ShowStatus.OPEN);
                }

                refund(booking);
            }
        }
    }
}
