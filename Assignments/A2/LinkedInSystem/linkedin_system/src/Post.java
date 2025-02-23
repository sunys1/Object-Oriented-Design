import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Post {
    private int postId;
    private int authorId;
    private String postTxt;
    private LocalDate postDate = LocalDate.now();
    private HashMap<Integer, Like> likes;

    public Post(int postId, int authorId, String postTxt) {
        this.postId = postId;
        this.authorId = authorId;
        this.postTxt = postTxt;
    }

    public int getPostId() {
        return postId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getPostTxt() {
        return postTxt;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public HashMap<Integer, Like> getLikes() {
        return likes;
    }
}
