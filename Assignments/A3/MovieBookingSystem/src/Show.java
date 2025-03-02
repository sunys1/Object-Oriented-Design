import java.time.LocalDateTime;

public class Show {
    private int showId;
    private LocalDateTime showTime;
    private String location;
    private Movie movie;
    private double price;
    private int totalSeats;
    private ShowStatus status;

    public Show(int showId, LocalDateTime showTime, String location, Movie movie, double price, int totalSeats, ShowStatus status) {
        this.showId = showId;
        this.showTime = showTime;
        this.location = location;
        this.movie = movie;
        this.price = price;
        this.totalSeats = totalSeats;
        this.status = status;
    }

    public int getShowId() {
        return showId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public String getLocation() {
        return location;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalSeats(){
        return totalSeats;
    }

    public ShowStatus getStatus() {
        return status;
    }

    public void setStatus(ShowStatus status) {
        this.status = status;
    }

    public String toString () {
        return "Show ID: " + showId + "\n" +
                "Show Time: " + showTime + "\n" +
               "Location: " + location + "\n" +
               "Movie: " + movie.getName() + "\n" +
               "Status: " + status.toString();
    }
}
