import java.util.ArrayList;
import java.util.List;

public class User {
     private int userId;
     private String userName;
     private List<User> connections;
     private List<User> followers;
     private List<User> following;
     private List<Post> posts;

     public User(int userId, String userName) {
         this.userId = userId;
         this.userName = userName;
         connections = new ArrayList<>();
         followers = new ArrayList<>();
         following = new ArrayList<>();
         posts = new ArrayList<>();
     }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<User> getConnections() {
        return connections;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
