package lesson35.model;

public class Session {
    private static User user;

    public Session() {
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Session.user = user;
    }

    @Override
    public String toString() {
        return "Session{" +
                "user=" + user +
                '}';
    }
}
