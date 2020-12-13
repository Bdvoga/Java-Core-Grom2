package lesson35.model;

import lesson35.repository.IdEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends IdEntity {
    private Long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private Double moneyPaid;

    public Order() {
    }

    public Order(Long id, User user, Room room, Date dateFrom, Date dateTo, Double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }

    @Override
    public Date getDateAvailableFrom() {
        return null;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return id + "," +
                user.getId() + "," +
                room.getId() + "," +
                new SimpleDateFormat("dd-MM-yyyy").format(dateFrom) + "," +
                new SimpleDateFormat("dd-MM-yyyy").format(dateTo) + "," +
                moneyPaid;
    }
}
