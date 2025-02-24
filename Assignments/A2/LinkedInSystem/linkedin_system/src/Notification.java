import javax.sound.midi.Receiver;
import java.time.LocalDateTime;

public class Notification {
    private int notificationId;
    private NotificationType type;
    private User sender;
    private User receiver;
    private Comment comment;
    private Comment parentComment;
    private Post post;
    private String message;
    private LocalDateTime notificationTime = LocalDateTime.now();

    // For Follow, Connect request/approval
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
        }else if (type == NotificationType.FOLLOW){
            this.message = "Hi, " + receiverName + ", " + senderName + " starts following you.";
        }
    }

    // For Comment_Post
    public Notification(int notificationId, NotificationType type, Post post, Comment comment) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = comment.getAuthor();
        this.receiver = post.getAuthor();
        this.comment = comment;
        this.post = post;
        this.message = "Hi, " + receiver.getUserName() + ", " + sender.getUserName() + " commented on your post '"
                + post.getPostTitle() + "'.";
    }

    // For Comment_parentComment
    public Notification(int notificationId, NotificationType type, Comment parentComment, Comment comment) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = comment.getAuthor();
        this.receiver = parentComment.getAuthor();
        this.comment = comment;
        this.parentComment = parentComment;
        this.post = parentComment.getPost();
        this.message = "Hi, " + receiver.getUserName() + ", " + sender.getUserName() + " commented on your comment '"
                + parentComment.getCommentTxt() + "' in the post '" + post.getPostTitle() + "'.";
    }

    // For Share
    public Notification(int notificationId, NotificationType type, Post post, User sender, User receiver) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.post = post;

        if (type == NotificationType.POST_SHARED) {
            this.message = "Hi, " + sender.getUserName() + ", " + sender.getUserName() + " shared your post '"
                    + post.getPostTitle() + "'.";
        }else if (type == NotificationType.SHARED_WITH_YOU){
            this.message = "Hi, " + receiver.getUserName() + ", " + sender.getUserName() + " shared a post with you: '"
                    + post.getPostTitle() + "'.";
        }
    }


    // For Like_Comment
    public Notification(int notificationId, NotificationType type, Comment comment, Like like) {
        this.notificationId = notificationId;
        this.type = type;
        this.sender = like.getAuthor();
        this.receiver = comment.getAuthor();
        this.comment = comment;
        this.message = "Hi, " + receiver.getUserName() + ", " + sender.getUserName() + " liked your comment '"
                + comment.getCommentTxt() + "' in the post '" + comment.getPost().getPostTitle() + "'.";
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

    public String getMessage() {
        return message;
    }

    public LocalDateTime getNotificationTime() {
        return notificationTime;
    }
}
