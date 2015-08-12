package com.epam.entity;

import java.util.Date;

/**
 * @author Yevhen_Vasyliev
 */
public class Ticket {

    private long id;
    private long idEvent;
    private Date date;
    private Seat seat;
    private User user;

    public Ticket() {
    }

    public Ticket(long id, Date date, Seat seat, User user) {
        this.id = id;
        this.date = date;
        this.seat = seat;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(long idEvent) {
        this.idEvent = idEvent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (idEvent != ticket.idEvent) return false;
        if (date != null ? !date.equals(ticket.date) : ticket.date != null) return false;
        if (seat != null ? !seat.equals(ticket.seat) : ticket.seat != null) return false;
        return !(user != null ? !user.equals(ticket.user) : ticket.user != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idEvent ^ (idEvent >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", idEvent=" + idEvent +
                ", date=" + date +
                ", seat=" + seat +
                ", user=" + user +
                '}';
    }
}
