import java.util.ArrayList;
import java.util.List;

public class User {
     private int userId;
     private String userName;
     private String title;

     public User(int userId, String userName, String title) {
         this.userId = userId;
         this.userName = userName;
         this.title = title;
     }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
         return title;
    }

    public void setTitle(String title) {
         this.title = title;
    }
}
