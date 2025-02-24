import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register {
    private ArrayList users = new ArrayList<>();
    private ArrayList posts = new ArrayList<>();
    private Map<Integer, ArrayList<User>> connections;
    private Map<Integer, ArrayList<User>> followers;
    private Map<Integer, ArrayList<User>> following;
    private Map<Integer, ArrayList<User>> connectSent;
    private Map<Integer, ArrayList<User>> connectReceived;
    private Map<Integer, ArrayList<Post>> myPosts;
    private Map<Integer, ArrayList<Comment>> myComments; // key: userId - All comments a user made
    private Map<Integer, ArrayList<Comment>> commentsReceived; // key: userId - All comments a user received
    private Map<Integer, ArrayList<Like>> myLikes; // key: userId - All posts a user liked
    private Map<Integer, ArrayList<Like>> likesReceived; // key: userId - All likes a user received from posts and comments
    private Map<Integer, ArrayList<Share>> myShares; // key: userId - All posts a user shared
    private Map<Integer, ArrayList<Share>> sharedByList;
    private Map<Integer, ArrayList<Notification>> notifications; // key: userId - All notifications a user received

    public Register() {
        this.users = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.connections = new HashMap<Integer, ArrayList<User>>();
        this.followers = new HashMap<Integer, ArrayList<User>>();
        this.following = new HashMap<Integer, ArrayList<User>>();
        this.connectSent = new HashMap<Integer, ArrayList<User>>();
        this.connectReceived = new HashMap<Integer, ArrayList<User>>();
        this.myPosts = new HashMap<Integer, ArrayList<Post>>();
        this.myComments = new HashMap<Integer, ArrayList<Comment>>();
        this.commentsReceived = new HashMap<Integer, ArrayList<Comment>>();
        this.myLikes = new HashMap<Integer, ArrayList<Like>>();
        this.likesReceived = new HashMap<Integer, ArrayList<Like>>();
        this.myShares = new HashMap<Integer, ArrayList<Share>>();
        this.sharedByList = new HashMap<Integer, ArrayList<Share>>();
        this.notifications = new HashMap<Integer, ArrayList<Notification>>();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Map<Integer, ArrayList<User>> getConnections() {
        return connections;
    }

    public Map<Integer, ArrayList<User>> getFollowers() {
        return followers;
    }

    public Map<Integer, ArrayList<User>> getFollowing() {
        return following;
    }

    public Map<Integer, ArrayList<User>> getConnectSent() {
        return connectSent;
    }

    public Map<Integer, ArrayList<User>> getConnectReceived() {
        return connectReceived;
    }

    public Map<Integer, ArrayList<Post>> getMyPosts() {
        return myPosts;
    }

    public Map<Integer, ArrayList<Comment>> getMyComments() {
        return myComments;
    }

    public Map<Integer, ArrayList<Comment>> getCommentsReceived() {
        return commentsReceived;
    }

    public Map<Integer, ArrayList<Like>> getMyLikes() {
        return myLikes;
    }

    public Map<Integer, ArrayList<Like>> getLikesReceived() {
        return likesReceived;
    }

    public Map<Integer, ArrayList<Share>> getMyShares() {
        return myShares;
    }

    public Map<Integer, ArrayList<Share>> getSharedByList() {
        return sharedByList;
    }

    public Map<Integer, ArrayList<Notification>> getNotifications() {
        return notifications;
    }
}
