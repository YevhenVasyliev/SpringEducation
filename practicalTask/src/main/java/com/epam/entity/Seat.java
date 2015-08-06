package com.epam.entity;

/**
 * @author Yevhen_Vasyliev
 */
public class Seat {

    private long id;
    private long number;
    private boolean isVip;

    public Seat(long id, long number, boolean isVip) {
        this.id = id;
        this.number = number;
        this.isVip = isVip;
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

    public boolean isVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (id != seat.id) return false;
        if (number != seat.number) return false;
        return isVip == seat.isVip;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (isVip ? 1 : 0);
        return result;
    }
}
