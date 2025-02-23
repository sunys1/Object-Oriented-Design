import java.time.LocalDate;

public class Like {
    private int likeId;
    private int authorId;
    private int postId;
    private int commentId;
    private LocalDate likeDate = LocalDate.now();

    public Like(int likeId, int authorId, int postId, int commentId) {
        this.likeId = likeId;
        this.authorId = authorId;
        this.postId = postId;
        this.commentId = commentId;
    }

    public int getLikeId() {
        return likeId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getPostId() {
        return postId;
    }

    public int getCommentId() {
        return commentId;
    }

    public LocalDate getLikeDate() {
        return likeDate;
    }
}
