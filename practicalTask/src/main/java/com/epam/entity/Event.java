package com.epam.entity;

import java.util.Date;

/**
 * @author Yevhen_Vasyliev
 */
public class Event {

    private long id;
    private String name;
    private Date startDate;
    private double price;
    private double priceVip;
    private Rating rating;
    private Auditorium auditorium;

    public Event(long id, String name, Date startDate, double price, Rating rating) {
        this.name = name;
        this.startDate = startDate;
        this.price = price;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getPrice() {
        return price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public double getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(double priceVip) {
        this.priceVip = priceVip;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (Double.compare(event.price, price) != 0) return false;
        if (Double.compare(event.priceVip, priceVip) != 0) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (startDate != null ? !startDate.equals(event.startDate) : event.startDate != null) return false;
        if (rating != event.rating) return false;
        return !(auditorium != null ? !auditorium.equals(event.auditorium) : event.auditorium != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceVip);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", price=" + price +
                ", priceVip=" + priceVip +
                ", rating=" + rating +
                ", auditorium=" + auditorium +
                '}';
    }
}
