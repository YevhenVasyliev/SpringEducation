package com.epam.entity;

/**
 * Created by Yevhen_Vasyliev on 12.08.2015.
 */
public class UserTicket {

    private long ticketId;
    private Event event;
    private Seat seat;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public long getTicketId() {

        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTicket that = (UserTicket) o;

        if (ticketId != that.ticketId) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        return !(seat != null ? !seat.equals(that.seat) : that.seat != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (ticketId ^ (ticketId >>> 32));
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        return result;
    }
}
