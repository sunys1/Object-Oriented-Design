import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Post {
    private int postId;
    private User author;
    private String postTitle;
    private String postTxt;
    private LocalDateTime postDate = LocalDateTime.now();
    private HashMap<Integer, Like> likes;

    public Post(int postId, User author, String postTitle, String postTxt) {
        this.postId = postId;
        this.author = author;
        this.postTitle = postTitle;
        this.postTxt = postTxt;
    }

    public int getPostId() {
        return postId;
    }

    public User getAuthor() {
        return author;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostTxt() {
        return postTxt;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public HashMap<Integer, Like> getLikes() {
        return likes;
    }
}
