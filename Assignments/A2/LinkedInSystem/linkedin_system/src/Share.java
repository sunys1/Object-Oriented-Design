import java.time.LocalDate;
import java.time.LocalDateTime;

public class Share {
    private int shareId;
    private Post post;
    private User sender;
    private User receiver;
    private LocalDateTime shareDate = LocalDateTime.now();

    public Share(int shareId, Post post, User sender, User receiver) {
        this.shareId = shareId;
        this.post = post;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getShareId() {
        return shareId;
    }

    public Post getPost() {
        return post;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }
}
