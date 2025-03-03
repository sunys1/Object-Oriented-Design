public class Movie extends Resource {
    private String genre;
    private String director;
    private String rating; // R，G, PG, etc
    private String language;
    private String duration;

    public Movie(String id, String name, int totalQuantity, String genre, String director, String rating,
                 String language, String duration) {
        super(id, name, totalQuantity);
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.language = language;
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public String getLanguage() {
        return language;
    }

    public String getDuration() {
        return duration;
    }

    public String toString() {
        return "Movie Details: " +
                "genre: '" + genre + '\'' +
                ", director: '" + director + '\'' +
                ", Rating: '" + rating + '\'' +
                ", language: '" + language + '\'' +
                ", duration: '" + duration + '\'';
    }
}
