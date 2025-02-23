import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Comment {
    private int commentId;
    private int authorId;
    private int postId;
    private String commentTxt;
    private LocalDate commentDate = LocalDate.now();
    private HashMap<Integer, Like> likes;

    public Comment(int commentId, int authorId, int postId, String commentTxt) {
        this.commentId = commentId;
        this.authorId = authorId;
        this.postId = postId;
        this.commentTxt = commentTxt;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getPostId() {
        return postId;
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
