package ca.ood._03_movie_recommendation_system;

public class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
