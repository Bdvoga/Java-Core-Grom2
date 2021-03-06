package lesson28.ex1;

import java.util.Date;

public class Capability implements Comparable<Capability> {
    private long id;
    private String channelName;
    private String fingerprint;
    private boolean isActive;
    private Date dateCreated;

    public Capability(long id, String channelName, String fingerprint, boolean isActive, Date dateCreated) {
        this.id = id;
        this.channelName = channelName;
        this.fingerprint = fingerprint;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public int compareTo(Capability capability) {
        System.out.println("comparedTo is used");
        return (int) (this.id - capability.getId());

        // Как работает
        //before: 1001, 1005, 900
        //step1: 1001 - 1005 = -4 отицательный рез сравнения - ничего не делаем
        //after: 1001, 1005, 900

        //before: 1001, 1005, 900
        //step2: 1005 - 900 = 105 меняем местами
        //after: 1001, 900, 1005

        //before: 1001, 900, 1005
        //step2: 1001 - 900 = 101 меняем местами
        //after: 900, 1001, 1005
    }

    @Override
    public String toString() {
        return "Capability{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
