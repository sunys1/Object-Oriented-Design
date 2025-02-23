import java.time.LocalDate;

public class Share {
    private int shareId;
    private int postId;
    private int receiverId;
    private LocalDate date = LocalDate.now();

    public Share(int shareId, int postId, int receiverId) {
        this.shareId = shareId;
        this.postId = postId;
        this.receiverId = receiverId;
    }

    public int getShareId() {
        return shareId;
    }

    public int getPostId() {
        return postId;
    }

    public int getReceiverId() {
        return receiverId;
    }
}
