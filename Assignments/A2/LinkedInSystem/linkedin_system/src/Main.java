import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedIn linkedIn = new LinkedIn();
        Register register = linkedIn.getRegister();

        // Create profile
        User u1 = linkedIn.createProfile(1, "User1", "Junior SDE");
        User u2 = linkedIn.createProfile(2, "User2", "Senior SDE");
        User u3 = linkedIn.createProfile(3, "User3", "Staff SDE");

        // Connection request
        linkedIn.connect(u1, u2);
        linkedIn.connect(u1, u3);
        // Approve connection request
        System.out.println();
        linkedIn.approve_connect(u2, u1);
        linkedIn.approve_connect(u3, u1);

        // View users's connections
        System.out.println();
        for (int i = 0; i < register.getUsers().size(); i++) {
            User u = register.getUsers().get(i);
            System.out.println(u.getUserName() + " is connected to: ");
            ArrayList<User> connections = register.getConnections().get(u.getUserId());

            for (int j = 0; j < connections.size(); j++) {
                System.out.println(connections.get(j).getUserName());
            }
            System.out.println();
        }

        // Follow
        linkedIn.follow(u1, u2);
        linkedIn.follow(u1, u3);
        linkedIn.follow(u2, u1);
        linkedIn.follow(u2, u3);
        linkedIn.follow(u3, u1);
        linkedIn.follow(u3, u2);

        // View users's followers & followings
        System.out.println();
        for (int i = 0; i < register.getUsers().size(); i++) {
            User u = register.getUsers().get(i);
            System.out.println(u.getUserName() + " is followed by: ");
            ArrayList<User> followers = register.getFollowers().get(u.getUserId());

            for (int j = 0; j < followers.size(); j++) {
                System.out.println(followers.get(j).getUserName());
            }
            System.out.println();
        }

        for (int i = 0; i < register.getUsers().size(); i++) {
            User u = register.getUsers().get(i);
            System.out.println(u.getUserName() + " is following: ");
            ArrayList<User> followings = register.getFollowing().get(u.getUserId());

            for (int j = 0; j < followings.size(); j++) {
                System.out.println(followings.get(j).getUserName());
            }
            System.out.println();
        }

        // Post
        Post p1 = linkedIn.createPost(1, u1, "OOD Practice 1", "Gomoku");
        Post p2 = linkedIn.createPost(2, u2, "OOD Practice 2", "Parking Lot System");
        Post p3 = linkedIn.createPost(3, u3, "OOD Practice 3", "Movie Recommendation");

        // View users's posts
        for (int i = 0; i < register.getUsers().size(); i++) {
            User u = register.getUsers().get(i);
            System.out.println(u.getUserName() + " has following posts: ");
            ArrayList<Post> posts = register.getMyPosts().get(u.getUserId());

            for (int j = 0; j < posts.size(); j++) {
                System.out.println(posts.get(j).getPostTitle());
            }
            System.out.println();
        }

        // Comment
        Comment c1 = linkedIn.comment(u2, "Well written!", p1, null);
        Comment c2 = linkedIn.comment(u1, "Thanks!", p1, c1);
        Comment c3 = linkedIn.comment(u2, "You're welcome", p1, c2);

        // Like
        System.out.println();
        linkedIn.likePost(u2, p1);
        linkedIn.likeComment(u1, c1);

        // Share
        System.out.println();
        linkedIn.sharePost(p1, u2, u3);
        linkedIn.sharePost(p1, u1, u1);
    }
}
