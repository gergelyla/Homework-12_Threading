package festivalEntranceApp.objectDefinitions;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    Queue<FestivalAttendee> gateQeue=new LinkedList();

    public synchronized Queue newAttendeeAtTheGate(FestivalAttendee festivalAttendee){
        gateQeue.add(festivalAttendee);
        return gateQeue;
    }

    public void listMembersOfQeue(){
        for (FestivalAttendee members:gateQeue){
            System.out.println(members);
        }
    }

    public synchronized void gateStatisticAtSpecificMoment(){
        int fullPassAmmount=0;
        int fullVipPassAmmount=0;
        int freePassAmmount=0;
        int oneDayPassAmmount=0;
        int oneDayVipPassAmmount=0;

        for (FestivalAttendee member : gateQeue) {
            switch (member.getTicketType()) {
                case FULL_PASS:
                    fullPassAmmount=fullPassAmmount+1;
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
        System.out.println("Amount of Full Passes: " + fullPassAmmount);
        System.out.println("Amount of Full VIP Passes: " + fullVipPassAmmount);
        System.out.println("Amount of Free Passes: " + freePassAmmount);
        System.out.println("Amount of One Day Passes: " + oneDayPassAmmount);
        System.out.println("Amount of One Day VIP Passes: " + oneDayVipPassAmmount);
    }

}
