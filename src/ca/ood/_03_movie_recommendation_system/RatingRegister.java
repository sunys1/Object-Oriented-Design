package ca.ood._03_movie_recommendation_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
    private Map<Integer, List<Movie>> userMovies; // key:userId value:the movies this user has watched
    private Map<Integer, Map<Integer, MovieRating>> movieRatings;
    private List<Movie> movies;
    private List<User> users;

    public RatingRegister() {
        this.userMovies = new HashMap<>();
        this.movieRatings = new HashMap<>();
        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addRating(User user, Movie movie, MovieRating rating) {
        // pass User and Movie objects instead of userId and movieId is easier
        if (!movieRatings.containsKey(movie.getId())) {
            movieRatings.put(movie.getId(), new HashMap<>());
            movies.add(movie);
        }

        if(!userMovies.containsKey(user.getId())) {
            userMovies.put(user.getId(), new ArrayList<>());
            users.add(user);
        }

        userMovies.get(user.getId()).add(movie);
        movieRatings.get(movie.getId()).put(user.getId(), rating);

    }

    public double getAverageRating(Movie movie) {
        Map<Integer, MovieRating> ratings = movieRatings.get(movie.getId());
        double averageRating;
        double totalRating = 0;

        for(Map.Entry<Integer, MovieRating> entry : ratings.entrySet()) {
            totalRating += entry.getValue().ordinal();
        }
        averageRating = totalRating / ratings.size();

        return averageRating;
    }

    public List<Movie> getUserMovies(User user) {
        return userMovies.get(user.getId());
    }
    public Map<Integer, MovieRating> getMovieRatings(Movie movie) {
        if (!movieRatings.containsKey(movie.getId())) {
            return new HashMap<>();
        }
        return movieRatings.get(movie.getId());
    }

    public List<User> getUsers() {
        if(!users.isEmpty()) {
            return users;
        }else{
            return new ArrayList<>();
        }
    }
    public List<Movie> getMovies(){
        if(!movies.isEmpty()) {
            return movies;
        }else{
            return new ArrayList<>();
        }
    }
}
