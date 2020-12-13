package lesson35.model;

import lesson35.repository.IdEntity;

import java.util.Date;

public class User extends IdEntity {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(Long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Date getDateAvailableFrom() {
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  id + "," +
                userName + "," +
                password + "," +
                country + "," +
                userType;
    }
}
