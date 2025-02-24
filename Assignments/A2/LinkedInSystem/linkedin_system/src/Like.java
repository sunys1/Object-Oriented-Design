import java.time.LocalDate;

public class Like {
    private int likeId;
    private User author;
    private Post post;
    private Comment comment;
    private LocalDate likeDate = LocalDate.now();

    public Like(int likeId, User author, Post post, Comment comment) {
        this.likeId = likeId;
        this.author = author;
        this.post = post;
        this.comment = comment;
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

    public LocalDate getLikeDate() {
        return likeDate;
    }
}
