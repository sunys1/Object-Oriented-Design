import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Show show;
    private int totalTickets;
    private Payment payment;
    private BookingStatus status = BookingStatus.PENDING;
    private List<Seat> seats;

    public Booking(String bookingId, User user, Show show, int totalTickets, Payment payment) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.totalTickets = totalTickets;
        this.payment = payment;
        this.seats = new ArrayList<>();
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public Payment getPayment() {
        return payment;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public String toString() {
        String seatDetails = "";

        for (Seat seat : seats) {
            seatDetails += seat + "\n";
        };

        return "Booking ID: " + bookingId + "\n" +
                "User: " + user.getUserName() + "\n" +
                show + "\n" +
               "Number of tickets: " + totalTickets + "\n" +
               "Seats: " + seatDetails + "\n" +
               payment;
    }
}
