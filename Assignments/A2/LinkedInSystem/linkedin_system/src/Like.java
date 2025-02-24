import java.time.LocalDate;
import java.time.LocalDateTime;

public class Like {
    private int likeId;
    private User author;
    private Post post;
    private Comment comment;
    private LocalDateTime likeDate = LocalDateTime.now();

    // For Like_Comment
    public Like(int likeId, User author, Comment comment) {
        this.likeId = likeId;
        this.author = author;
        this.post = post;
        this.comment = comment;
    }

    // For Like_Post
    public Like(int likeId, User author, Post post) {
        this.likeId = likeId;
        this.author = author;
        this.post = post;
    }

    public int getLikeId() {
        return likeId;
    }

    public User getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    public Comment getComment() {
        return comment;
    }

    public LocalDateTime getLikeDate() {
        return likeDate;
    }
}
