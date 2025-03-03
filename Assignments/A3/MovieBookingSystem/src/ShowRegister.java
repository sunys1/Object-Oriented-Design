import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowRegister {
    private Map<String, List<Show>> shows; // Key: movie id
    private Map<Integer, List<Seat>> showSeats;

    public ShowRegister() {
        this.shows = new HashMap<>();
        this.showSeats = new HashMap<>();
    }

    // Return shows status to MovieManager
    public List<Show> getShows(String movieId) {
        return shows.get(movieId);
    }

    // Return available shows to MovieManager
    public List<Show> getAvailableShows(String movieId) {
        List<Show> availableShows = new ArrayList<>();

        for (Show show : shows.get(movieId)) {
            if (show.getStatus() == ShowStatus.OPEN) {
                availableShows.add(show);
            }
        }

        return availableShows;
    }

    // Return seats status to MovieManager
    public List<Seat> getShowSeats (int showId) {
        return showSeats.get(showId);
    }

    // Return available seats to MovieManager
    public List<Seat> getAvailableShowSeats(int showId) {
        List<Seat> seats = showSeats.get(showId);

        return seats.stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public void addShow(Show show) {
        String movieId = show.getMovie().getId();
        int showId = show.getShowId();

        // Check if movie exists: a show must be associated with a movie
        if (!shows.containsKey(movieId)) {
            shows.put(movieId, new ArrayList<>());
        }

        shows.get(movieId).add(show);
        showSeats.put(showId, new ArrayList<>());

        // Add seats to showSeats map
        for (int i = 1; i <= show.getTotalSeats(); i++) {
            Seat seat = new Seat("S" + i, SeatStatus.AVAILABLE);
            showSeats.get(showId).add(seat);
        }
    }

    public void updateSeatStatus(int showId, String seatId, SeatStatus status) {
        List<Seat> seats = showSeats.get(showId);
        // Avoid creating a new string, extra memory allocation, and intermediate string processing
        // No noticeable performance difference though, unless for very large volume processing
        int sid = 0;
        for (int i = 1; i < seatId.length(); i++) {
            sid = sid * 10 + (seatId.charAt(i) - '0');
        }
        Seat seat = seats.get(sid - 1); // Seat ID: S1, S2, S3, etc
        seat.setStatus(status);
    }
}
