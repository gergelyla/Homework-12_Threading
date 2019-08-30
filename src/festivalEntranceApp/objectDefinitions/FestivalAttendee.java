package festivalEntranceApp.objectDefinitions;

public class FestivalAttendee {
    private String attendeeName;
    private TicketTypes ticketType;

    public FestivalAttendee(TicketTypes ticketType) {
        this.ticketType = ticketType;
    }

    public TicketTypes getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypes ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "FestivalAttendee ticket type: " + ticketType;
    }
}
