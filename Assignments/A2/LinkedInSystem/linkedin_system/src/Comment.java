import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Comment {
    private int commentId;
    private User author;
    private Post post;
    private String commentTxt;
    private LocalDate commentDate = LocalDate.now();
    private HashMap<Integer, Like> likes;

    public Comment(int commentId, User author, Post post, String commentTxt) {
        this.commentId = commentId;
        this.author = author;
        this.post = post;
        this.commentTxt = commentTxt;
    }

    public int getCommentId() {
        return commentId;
    }

    public User getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    public String getCommentTxt() {
        return commentTxt;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public HashMap<Integer, Like> getLikes() {
        return likes;
    }
}
