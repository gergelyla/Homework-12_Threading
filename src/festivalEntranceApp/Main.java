package festivalEntranceApp;

import festivalEntranceApp.objectDefinitions.FestivalGate;
import festivalEntranceApp.objectDefinitions.GeneratorThread;
import festivalEntranceApp.objectDefinitions.StatisticalThread;


public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        GeneratorThread ticketValidationThread = new GeneratorThread(gate);
        StatisticalThread statisticalThread = new StatisticalThread(gate);
        ticketValidationThread.start();
        statisticalThread(gate, statisticalThread);
    }

    private static void statisticalThread(FestivalGate gate, StatisticalThread statisticalThread) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Starting statistical thread...");
        System.out.println("-------------------------------------------------------------");
        statisticalThread.setPriority(10);
//        statisticalThread.setDaemon(true);
        statisticalThread.start();
    }

}
