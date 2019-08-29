package festivalEntranceApp;

import festivalEntranceApp.objectDefinitions.FestivalAttendeeThread;
import festivalEntranceApp.objectDefinitions.FestivalGate;
import festivalEntranceApp.objectDefinitions.StatisticalThread;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FestivalGate gate=new FestivalGate();
        StatisticalThread statisticalThread=new StatisticalThread(gate);
        int numberOfAttendees=0;
        numberOfAttendees=generateRandomNumberOfAttendees(numberOfAttendees);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Number of potential attendees to the festival is: "+numberOfAttendees);
        System.out.println("-------------------------------------------------------------");
        statisticalThread(gate);
        openingGateToFestival(gate, numberOfAttendees);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Final statistics after festival: ");
        System.out.println("-------------------------------------------------------------");
        gate.gateStatisticAtSpecificMoment();
    }

    private static void statisticalThread(FestivalGate gate) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Starting statistical thread...");
        System.out.println("-------------------------------------------------------------");
    }

    private static void openingGateToFestival(FestivalGate gate, int numberOfAttendees) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Opening gates to the festival...");
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i<numberOfAttendees; i++){
            runNewAttendeeThread(gate, i);
        }
    }

    private static void runNewAttendeeThread(FestivalGate gate, int i) {
        FestivalAttendeeThread attendeeThread=new FestivalAttendeeThread(gate);
        attendeeThread.setName("attendee"+i);
        attendeeThread.start();
        try {
            attendeeThread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int generateRandomNumberOfAttendees(int numberOfAttendees) {
       while (numberOfAttendees<100){
            Random random=new Random();
            numberOfAttendees=random.nextInt(200);
        }
        return  numberOfAttendees;
    }
}
