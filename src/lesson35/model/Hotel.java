package lesson35.model;

import lesson35.repository.IdEntity;

import java.util.Date;

public class Hotel extends IdEntity {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(Long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    @Override
    public Date getDateAvailableFrom() {
        return null;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "," +
                name + "," +
                country + "," +
                city + "," +
                street;
    }
}
