import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Comment {
    private int commentId;
    private User author;
    private Post post;
    private Comment parentComment;
    private String commentTxt;
    private LocalDateTime commentDate = LocalDateTime.now();
    private HashMap<Integer, Like> likes;

    // For Comment_Post
    public Comment(int commentId, User author, Post post, String commentTxt) {
        this.commentId = commentId;
        this.author = author;
        this.post = post;
        this.commentTxt = commentTxt;
    }

    // For Comment_parentComment
    public Comment(int commentId, User author, Comment parentComment, String commentTxt) {
        this.commentId = commentId;
        this.author = author;
        this.post = parentComment.getPost();
        this.parentComment = parentComment;
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

    public Comment getParentComment() {
        return parentComment;
    }

    public String getCommentTxt() {
        return commentTxt;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public HashMap<Integer, Like> getLikes() {
        return likes;
    }
}
