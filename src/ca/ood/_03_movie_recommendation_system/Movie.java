package ca.ood._03_movie_recommendation_system;

public class Movie {
    private int movieId;
    private String title;

    public Movie(int movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }

    public int getId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }
}
