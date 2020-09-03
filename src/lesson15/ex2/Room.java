package lesson15.ex2;

import java.util.Date;

public class Room {
    private long id;
    private int price;
    private int person;
    private Date dateAvailableFrom;
    private String cityName;
    private String hotelName;

    public Room(long id, int price, int person, Date dateAvailableFrom, String cityName, String hotelName) {
        this.id = id;
        this.price = price;
        this.person = person;
        this.dateAvailableFrom = dateAvailableFrom;
        this.cityName = cityName;
        this.hotelName = hotelName;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPerson() {
        return person;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (price != room.price) return false;
        if (person != room.person) return false;
        if (!cityName.equals(room.cityName)) return false;
        return hotelName.equals(room.hotelName);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + person;
        result = 31 * result + cityName.hashCode();
        result = 31 * result + hotelName.hashCode();
        return result;
    }
}