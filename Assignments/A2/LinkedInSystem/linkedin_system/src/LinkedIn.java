import java.util.ArrayList;
import java.util.List;

public class LinkedIn {
    private Register register;

    public LinkedIn(Register register) {
        this.register = register;
    }

    public User createProfile(int userId, String userName, String title) {
        User user = new User(userId, userName, title);

        register.getUsers().add(user);
        register.getConnections().put(userId, new ArrayList<User>());
        register.getFollowers().put(userId, new ArrayList<User>());
        register.getFollowing().put(userId, new ArrayList<User>());
        register.getConnectSent().put(userId, new ArrayList<>());
        register.getConnectReceived().put(userId, new ArrayList<>());
        register.getMyPosts().put(userId, new ArrayList<Post>());
        register.getMyComments().put(userId, new ArrayList<Comment>());
        register.getCommentsReceived().put(userId, new ArrayList<Comment>());
        register.getMyLikes().put(userId, new ArrayList<Like>());
        register.getLikesReceived().put(userId, new ArrayList<Like>());
        register.getMyShares().put(userId, new ArrayList<Share>());
        register.getSharedByList().put(userId, new ArrayList<Share>());
        register.getNotifications().put(userId, new ArrayList<Notification>());

        return user;
    }

    public void connect(User sender, User receiver) {
        List<User> senderNetwork = register.getConnections().get(sender.getUserId());

        if (!senderNetwork.contains(receiver)) {
            // Notify receiver
            int notificationId = register.getNotifications().get(receiver.getUserId()).size() + 1;
            Notification notification = notifyFollowConnect(notificationId, NotificationType.CONNECT_RECEIVED, sender, receiver);
            register.getConnectSent().get(sender.getUserId()).add(receiver);
            register.getConnectReceived().get(receiver.getUserId()).add(sender);
        }
    }

    public void approve_connect(User sender, User receiver) {
        List<User> senderNetwork = register.getConnections().get(sender.getUserId());
        List<User> receiverNetwork = register.getConnections().get(receiver.getUserId());

        senderNetwork.add(receiver);
        receiverNetwork.add(sender);

        register.getConnectReceived().get(sender.getUserId()).remove(receiver);
        register.getConnectSent().get(receiver.getUserId()).remove(sender);

        // Notify receiver
        int notificationId = register.getNotifications().get(receiver.getUserId()).size() + 1;
        Notification notification = notifyFollowConnect(notificationId, NotificationType.CONNECT_APPROVED, sender, receiver);
    }

    public void follow(User sender, User receiver) {
        register.getFollowing().get(sender.getUserId()).add(receiver);
        register.getFollowers().get(receiver.getUserId()).add(sender);

        // Notify receiver
        int notificationId = register.getNotifications().get(receiver.getUserId()).size() + 1;
        Notification notification = notifyFollowConnect(notificationId, NotificationType.FOLLOW, sender, receiver);
    }

    public Post createPost(int postId, User author, String postTxt) {
        Post post = new Post(postId, author, postTxt);

        register.getMyPosts().get(author.getUserId()).add(post); // Add to user's post list
        register.getPosts().add(post); // Add to the list of all posts

        return post;
    }

    public void likePost(Post post, User sender){
        int likeId = register.getMyLikes().get(sender.getUserId()).size() + 1;
        Like like = new Like(likeId, sender, post);

        register.getMyLikes().get(sender.getUserId()).add(like); //Add to myLikes
        register.getLikesReceived().get(post.getAuthor().getUserId()).add(like); // Add to post author's list of likes received

        // Notify receiver
        int notificationId = register.getNotifications().get(post.getAuthor().getUserId()).size() + 1;
        Notification notification = notifyLikePost(notificationId, NotificationType.LIKE, post, like);
    }

    public void likeComment(Post post, Comment comment, User sender){
        int likeId = register.getMyLikes().get(sender.getUserId()).size() + 1;
        Like like = new Like(likeId, sender, comment);

        register.getMyLikes().get(sender.getUserId()).add(like); //Add to myLikes
        register.getLikesReceived().get(comment.getAuthor().getUserId()).add(like); // Add to comment author's list of likes received

        // Notify receiver
        int notificationId = register.getNotifications().get(comment.getAuthor().getUserId()).size() + 1;
        Notification notification = notifyLikeComment(notificationId, NotificationType.LIKE, comment, like);
    }

    public void sharePost(Post post, User sender, User receiver) {
        int shareId = register.getMyShares().get(sender.getUserId()).size() + 1;
        Share share = new Share(shareId, post, sender, receiver);
        register.getMyShares().get(sender.getUserId()).add(share); // Add to myShares
        register.getSharedByList().get(post.getAuthor().getUserId()).add(share); // Add to post author's sharedByList

        // Notify receiver
        int notificationReceiverId = register.getNotifications().get(receiver.getUserId()).size() + 1;
        Notification notificationReceiver = notifyShare(notificationReceiverId, NotificationType.SHARED_WITH_YOU, post, sender, receiver);

        // Notify post author
        int notificationPostAuthorId = register.getNotifications().get(post.getAuthor().getUserId()).size() + 1;
        Notification notificationPostAuthor = notifyShare(notificationPostAuthorId, NotificationType.POST_SHARED, post, sender, receiver);
    }

    public void comment(User author, String commentTxt, Post post, Comment parentComment) {
        int commentId = register.getMyComments().get(author.getUserId()).size() + 1;
        // For Comment_Post
        if(parentComment == null){
            Comment comment = new Comment(commentId, author, post, commentTxt);
            register.getMyComments().get(author.getUserId()).add(comment); // Add to comment author's comment list
            register.getCommentsReceived().get(post.getAuthor().getUserId()).add(comment); // Add to post author's list of comments received

            int notificationId = register.getNotifications().get(post.getAuthor().getUserId()).size() + 1;
            Notification notification = notifyCommentPost(notificationId, NotificationType.COMMENT_POST, post, comment);
        }else {
            // For Comment_parentComment
            Comment comment = new Comment(commentId, author, parentComment, commentTxt);
            register.getMyComments().get(author.getUserId()).add(comment); // Add to comment author's comment list
            register.getCommentsReceived().get(parentComment.getAuthor().getUserId()).add(comment); // Add to parent comment author's list of comments received

            int notificationId = register.getNotifications().get(parentComment.getAuthor().getUserId()).size() + 1;
            Notification notification = notifyCommentComment(notificationId, NotificationType.COMMENT_COMMENT, parentComment, comment);
        }
    }

    public Notification notifyFollowConnect(int notificationId, NotificationType type, User sender, User receiver) {
        Notification notification = new Notification(notificationId, type, sender, receiver);

        register.getNotifications().get(receiver.getUserId()).add(notification);
        System.out.println(notification.getMessage());

        return notification;
    }

    public Notification notifyCommentPost(int notificationId, NotificationType type, Post post, Comment comment) {
        Notification notification = new Notification(notificationId, type, post, comment);

        register.getNotifications().get(post.getAuthor().getUserId()).add(notification);
        System.out.println(notification.getMessage());

        return notification;
    }

    public Notification notifyCommentComment(int notificationId, NotificationType type, Comment parentComment, Comment comment) {
        Notification notification = new Notification(notificationId, type, parentComment, comment);

        register.getNotifications().get(parentComment.getAuthor().getUserId()).add(notification);
        System.out.println(notification.getMessage());

        return notification;
    }

    public Notification notifyLikeComment(int notificationId, NotificationType type, Comment comment, Like like) {
        Notification notification = new Notification(notificationId, type, comment, like);

        register.getNotifications().get(comment.getAuthor().getUserId()).add(notification);
        System.out.println(notification.getMessage());

        return notification;
    }

    public Notification notifyLikePost(int notificationId, NotificationType type, Post post, Like like){
        Notification notification = new Notification(notificationId, type, post, like);

        register.getNotifications().get(post.getAuthor().getUserId()).add(notification);
        System.out.println(notification.getMessage());

        return notification;
    }

    public Notification notifyShare(int notificationId, NotificationType type, Post post, User sender, User receiver) {
        Notification notification = new Notification(notificationId, type, post, sender, receiver);

        register.getNotifications().get(receiver.getUserId()).add(notification);
        System.out.println(notification.getMessage());

        return notification;
    }
}
