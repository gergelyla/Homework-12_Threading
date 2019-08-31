package festivalEntranceApp.objectDefinitions;

public class FestivalAttendeeThread extends Thread {
    private FestivalGate gate;

    public FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        FestivalAttendee attendee = new FestivalAttendee(TicketTypes.randomTicketType());
        gate.newAttendeeAtTheGate(attendee);
        System.out.println(attendee);
        System.out.println("Size of qeue at the gate after " + currentThread().getName() + " : " + gate.gateQueue.size());
    }
}
