package festivalEntranceApp.objectDefinitions;

public class StatisticalThread extends Thread{
    private FestivalGate gate;

    public StatisticalThread(FestivalGate gate){
        this.gate=gate;
    }

    @Override
    public void run() {
        currentThread().setDaemon(true);
        gate.gateStatisticAtSpecificMoment();
    }
}
