package festivalEntranceApp;

import festivalEntranceApp.objectDefinitions.GeneratorThread;


public class Main {
    public static void main(String[] args) {
        GeneratorThread ticketValidationThread = new GeneratorThread();
        ticketValidationThread.start();
    }
}
