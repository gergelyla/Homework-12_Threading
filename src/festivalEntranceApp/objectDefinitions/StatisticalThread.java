package festivalEntranceApp.objectDefinitions;

public class StatisticalThread extends Thread {
    public FestivalGate gate;

    public StatisticalThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (gate.gateQueue.size() != 0) {
            System.out.println(currentThread().getName());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Ticket statistics at certain point: ");
            gate.gateStatisticAtSpecificMoment();
            System.out.println("Sleeeeeeeping...5...4...3...2...1 ");
            try {
                currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" ");
        System.out.println("Festival gates closed! All attendees have arrived! Good night! ");
    }
}
