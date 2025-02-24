import javax.sound.midi.Receiver;
import java.time.LocalDateTime;

public class Notification {
    private int notificationId;
    private NotificationType type;
    private User sender;
    private User receiver;
    private Comment comment;
    private Post post;
    private String message;
    private LocalDateTime notificationTime = LocalDateTime.now();

    // For Connect request/approval
    public Notification(int notificationId, NotificationType type, User sender, User receiver) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        String senderName = sender.getUserName();
        String receiverName = receiver.getUserName();

        if (type == NotificationType.CONNECT_RECEIVED) {
            this.message = "Hi, " + receiverName + ", you received a connection request from " + senderName + ".";
        }else if (type == NotificationType.CONNECT_APPROVED){
            this.message = "Hi, " + receiverName + ", " + senderName + " approved your connection request.";
        }
    }

    // For Comment
    public Notification(int notificationId, NotificationType type, Post post, Comment comment) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = comment.getAuthor();
        this.receiver = post.getAuthor();
        this.comment = comment;
        this.post = post;
        this.message = "Hi, " + receiver.getUserName() + ", you received a comment from " + sender.getUserName()
                + " in your post '" + post.getPostTitle() + "'.";
    }

    // For Like_Comment
    public Notification(int notificationId, NotificationType type, Post post, Comment comment, Like like) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = like.getAuthor();
        this.receiver = comment.getAuthor();
        this.comment = comment;
        this.post = post;
        this.message = "Hi, " + receiver.getUserName() + ", " + sender.getUserName() + " liked your comment '"
                + comment.getCommentTxt() + "' in the post '" + post.getPostTitle() + "'.";
    }

    // For Like_Post
    public Notification(int notificationId, NotificationType type, Post post, Like like) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = like.getAuthor();
        this.post = post;
        this.message = "Hi, " + receiver.getUserName() + ", " + sender.getUserName() + " liked your post '"
                + post.getPostTitle() + "'.";
    }

    public int getNotificationId() {
        return notificationId;
    }

    public NotificationType getType() {
        return type;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Comment getComment() {
        return comment;
    }

    public Post getPost() {
        return post;
    }

    public LocalDateTime getNotificationTime() {
        return notificationTime;
    }
}
