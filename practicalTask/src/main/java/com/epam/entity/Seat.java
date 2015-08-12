package com.epam.entity;

/**
 * @author Yevhen_Vasyliev
 */
public class Seat {

    private long id;
    private long number;
    private SeatType seatType;

    public Seat() {
    }

    public Seat(long id, long number, SeatType seatType) {
        this.id = id;
        this.number = number;
        this.seatType = seatType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (id != seat.id) return false;
        if (number != seat.number) return false;
        return seatType == seat.seatType;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (seatType != null ? seatType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", number=" + number +
                ", seatType=" + seatType +
                '}';
    }
}
