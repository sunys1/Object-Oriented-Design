import java.time.LocalDateTime;

public class Notification {
    private int notificationId;
    private NotificationType type;
    private Comment comment;
    private Post post;
    private LocalDateTime notificationTime = LocalDateTime.now();

    public Notification(int notificationId, NotificationType type, Comment comment, Post post) {
        this.notificationId = notificationId;
        this.type = type;
        this.comment = comment;
        this.post = post;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public NotificationType getType() {
        return type;
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
