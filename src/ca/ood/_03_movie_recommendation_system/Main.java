package ca.ood._03_movie_recommendation_system;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "u1");
        User user2 = new User(2, "u2");
        User user3 = new User(3, "u3");

        Movie movie1 = new Movie(1, "Captain America");
        Movie movie2 = new Movie(2, "Iron Man");
        Movie movie3 = new Movie(3, "Spider Man");

        RatingRegister re = new RatingRegister();
        re.addRating(user1, movie1, MovieRating.FIVE);
        re.addRating(user1, movie2, MovieRating.FOUR);
        re.addRating(user2, movie1, MovieRating.FIVE);
        re.addRating(user2, movie3, MovieRating.THREE);
        re.addRating(user2, movie1, MovieRating.FIVE);
        re.addRating(user3, movie2, MovieRating.FOUR);
        re.addRating(user3, movie3, MovieRating.THREE);

        RecommendationSystem sys = new RecommendationSystem(re);
        System.out.println(sys.recommendMovie(user1));
    }
}
