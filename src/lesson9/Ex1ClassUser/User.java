package lesson9.Ex1ClassUser;

public class User {
    private long id; // поля
    private String name;
    private String sessionId;

    public User(long id, String name, String sessionId) { // конструктор
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public long getId() { // Getter - разрешаем доставать значение
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }
}