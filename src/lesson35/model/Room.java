package lesson35.model;

import lesson35.repository.IdEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends IdEntity {
    private Long id;
    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(Long id, Integer numberOfGuests, Double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public Boolean getPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "," +
                numberOfGuests + "," +
                price + "," +
                breakfastIncluded + "," +
                petsAllowed + "," +
                new SimpleDateFormat("dd-MM-yyyy").format(dateAvailableFrom) + "," +
                hotel.getId();
    }
}