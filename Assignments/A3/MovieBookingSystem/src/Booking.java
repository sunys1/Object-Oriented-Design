import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private Show show;
    private int totalTickets;
    private Payment payment;

    public Booking(String bookingId, Show show, int totalTickets, Payment payment) {
        this.bookingId = bookingId;
        this.show = show;
        this.totalTickets = totalTickets;
        this.payment = payment;
    }

    public String getBookingId() {
        return bookingId;
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

    public String toString() {
        return "Booking ID: " + bookingId + "\n" +
               "Show: " + show + "\n" +
               "Number of tickets: " + totalTickets + "\n" +
               payment;
    }
}
