import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register {
    private Map<Integer, List<User>> connections;
    private Map<Integer, List<User>> followers;
    private Map<Integer, List<User>> following;
    private Map<Integer, List<User>> connectSent;
    private Map<Integer, List<User>> connectReceived;
    private Map<Integer, List<Post>> posts;
    private Map<Integer, List<Comment>> myComments; // key: userId - All comments a user made
    private Map<Integer, List<Comment>> commentsReceived; // key: userId - All comments a user received
    private Map<Integer, List<Like>> myLikes; // key: userId - All posts a user liked
    private Map<Integer, List<Like>> likesReceived; // key: userId - All likes a user received from posts and comments
    private Map<Integer, List<Share>> myShares; // key: userId - All posts a user shared
    private Map<Integer, List<Share>> sharesReceived; // key: userId - All shares a user received from connections
    private Map<Integer, List<Notification>> notifications; // key: userId - All notifications a user received

    public Register() {
        this.connections = new HashMap<Integer, List<User>>();
        this.followers = new HashMap<Integer, List<User>>();
        this.following = new HashMap<Integer, List<User>>();
        this.connectSent = new HashMap<Integer, List<User>>();
        this.connectReceived = new HashMap<Integer, List<User>>();
        this.posts = new HashMap<Integer, List<Post>>();
        this.myComments = new HashMap<Integer, List<Comment>>();
        this.commentsReceived = new HashMap<Integer, List<Comment>>();
        this.myLikes = new HashMap<Integer, List<Like>>();
        this.likesReceived = new HashMap<Integer, List<Like>>();
        this.myShares = new HashMap<Integer, List<Share>>();
        this.sharesReceived = new HashMap<Integer, List<Share>>();
        this.notifications = new HashMap<Integer, List<Notification>>();
    }

    public Map<Integer, List<User>> getConnections() {
        return connections;
    }

    public Map<Integer, List<User>> getFollowers() {
        return followers;
    }

    public Map<Integer, List<User>> getFollowing() {
        return following;
    }

    public Map<Integer, List<User>> getConnectSent() {
        return connectSent;
    }

    public Map<Integer, List<User>> getConnectReceived() {
        return connectReceived;
    }

    public Map<Integer, List<Post>> getPosts() {
        return posts;
    }

    public Map<Integer, List<Comment>> getMyComments() {
        return myComments;
    }

    public Map<Integer, List<Comment>> getCommentsReceived() {
        return commentsReceived;
    }

    public Map<Integer, List<Like>> getMyLikes() {
        return myLikes;
    }

    public Map<Integer, List<Like>> getLikesReceived() {
        return likesReceived;
    }

    public Map<Integer, List<Share>> getMyShares() {
        return myShares;
    }

    public Map<Integer, List<Share>> getSharesReceived() {
        return sharesReceived;
    }

    public Map<Integer, List<Notification>> getNotifications() {
        return notifications;
    }
}