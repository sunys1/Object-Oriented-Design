package ca.ood._03_movie_recommendation_system;

import java.util.Map;

public class RecommendationSystem {
    private RatingRegister register;

    public RecommendationSystem(RatingRegister register) {
        this.register = register;
    }
    public String recommendMovie(User user){
        // new user
        if(register.getUserMovies(user).isEmpty()){
            return recommendMovieNewUser();
        }else{// existing user
            return recommendExistingUser(user);
        }
    }

    public String recommendMovieNewUser(){
        double bestRating = 0.0;
        Movie bestMovie = null;
        for(Movie movie : register.getMovies()){
            double rating = register.getAverageRating(movie);
            if(rating > bestRating){
                bestRating = rating;
                bestMovie = movie;
            }
        }

        if(bestMovie != null){
            return bestMovie.getTitle();
        }else{
            return null;
        }

    }

    public String recommendExistingUser(User user){
        int similarityScore = Integer.MAX_VALUE;
        Movie bestMovie = null;
        User bestReviewer = null;

        // find the reviwer with the greatest similarity, then recommend the unwatched films for the user from
        // the reviewer's watched list
        for(User reviewer : register.getUsers()){
            if(reviewer.getId() == user.getId()) continue;
            int similarity = getSimilarity(user, reviewer);
            if(similarity < similarityScore){
                similarityScore = similarity;
                bestReviewer = reviewer;
            }
        }

        Movie movie = recommendUnwatchedMovie(user, bestReviewer);
        bestMovie = movie != null ? movie : bestMovie;

        return bestMovie.getTitle();
    }

    private Movie recommendUnwatchedMovie(User user, User reviewer) {
        Movie bestMovie = null;
        int bestRating = 0;

        for(Movie movie : register.getUserMovies(reviewer)){
            Map<Integer, MovieRating> rating = register.getMovieRatings(movie);
            if(!rating.containsKey(user.getId()) && rating.get(reviewer.getId()).ordinal() > bestRating){
                bestMovie = movie;
                bestRating = rating.get(reviewer.getId()).ordinal();
            }
        }

        return bestMovie;
    }

    // calculate the similarity of preference: smaller score means greater similarity
    public int getSimilarity(User user1, User user2){
        int similarity = Integer.MAX_VALUE;

        for(Movie movie : register.getUserMovies(user2)){
            Map<Integer, MovieRating> ratings = register.getMovieRatings(movie);
            if(ratings.containsKey(user1.getId())){
                similarity = similarity == Integer.MAX_VALUE ? 0 : similarity;
                similarity += Math.abs(ratings.get(user1.getId()).ordinal() - ratings.get(user2.getId()).ordinal());
            }
        }

        return similarity;
    }
}
