package festivalEntranceApp.objectDefinitions;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    private int fullPassAmmount = 0;
    private int fullVipPassAmmount = 0;
    private int freePassAmmount = 0;
    private int oneDayPassAmmount = 0;
    private int oneDayVipPassAmmount = 0;

    Queue<FestivalAttendee> gateQueue = new LinkedList();


    public synchronized void newAttendeeAtTheGate(FestivalAttendee festivalAttendee) {
        gateQueue.add(festivalAttendee);
    }

    public synchronized void gateStatisticAtSpecificMoment() {
        for (int i = 0; i < gateQueue.size(); i++) {
            switch (/*member*/gateQueue.poll().getTicketType()) {
                case FULL_PASS:
                    fullPassAmmount = fullPassAmmount + 1;
                    break;
                case FULL_VIP_PASS:
                    fullVipPassAmmount++;
                    break;
                case FREE_PASS:
                    freePassAmmount++;
                    break;
                case ONE_DAY_PASS:
                    oneDayPassAmmount++;
                    break;
                case ONE_DAY_VIP_PASS:
                    oneDayVipPassAmmount++;
                    break;
                default:
                    break;
            }
        }
        printQueueData();
    }

    private void printQueueData() {
        System.out.println("Amount of Full Passes: " + fullPassAmmount);
        System.out.println("Amount of Full VIP Passes: " + fullVipPassAmmount);
        System.out.println("Amount of Free Passes: " + freePassAmmount);
        System.out.println("Amount of One Day Passes: " + oneDayPassAmmount);
        System.out.println("Amount of One Day VIP Passes: " + oneDayVipPassAmmount);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("A total of " + (fullPassAmmount + fullVipPassAmmount + freePassAmmount + oneDayPassAmmount + oneDayVipPassAmmount) + " attendees have passed gate/ticket validation!");
        System.out.println("Number of attendees remaining in qeue: " + gateQueue.size());
        System.out.println("");
    }
}
