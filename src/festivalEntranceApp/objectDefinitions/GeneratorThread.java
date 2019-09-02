package festivalEntranceApp.objectDefinitions;

import java.util.Random;

public class GeneratorThread extends Thread {

    @Override
    public void run() {
        FestivalGate gate = new FestivalGate();
        StatisticalThread statisticalThread = new StatisticalThread(gate);
        statisticalThread(statisticalThread);
        int numberOfAttendees = 0;
        numberOfAttendees = generateRandomNumberOfAttendees(numberOfAttendees);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Number of potential attendees to the festival is: " + numberOfAttendees);
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Opening gates to the festival...");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < numberOfAttendees; i++) {
            runNewAttendeeThread(gate, i);
        }

    }

    private static void statisticalThread(StatisticalThread statisticalThread) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Starting statistical thread...");
        System.out.println("-------------------------------------------------------------");
        statisticalThread.setPriority(10);
//        statisticalThread.setDaemon(true);
        statisticalThread.start();
    }

    public void runNewAttendeeThread(FestivalGate gate, int i) {
        FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(gate);
        attendeeThread.setName("attendee" + i);
        attendeeThread.setPriority(7);
        attendeeThread.start();
        try {
            attendeeThread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int generateRandomNumberOfAttendees(int numberOfAttendees) {
        while (numberOfAttendees < 100) {
            Random random = new Random();
            numberOfAttendees = random.nextInt(200);
        }
        return numberOfAttendees;
    }
}
