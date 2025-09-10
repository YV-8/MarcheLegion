package university.jala.Legion.desingPatterns;

public class TimeSingleton {
    private long startCountTime = 0;
    private final int timeSleep;
    private long timeCounted = 0;
    private static TimeSingleton instance;
    /**
     * This construction  is a singleton for instance the timeSleep
     * time sleep is the time that each board must wait continue printing
     */
    private TimeSingleton(int timeSleep) {
        this.timeSleep = timeSleep;
    }
    public static TimeSingleton getInstance(int timeSleep) {
        if(instance == null) {
            instance = new TimeSingleton(timeSleep);
        }
        return instance;
    }
    public void sleepToBoard(){
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
        }
    }
    public void startIteration() {
        startCountTime = System.currentTimeMillis();
    }
    public void endIteration() {
        long endCountTime = System.currentTimeMillis();
        timeCounted += (endCountTime - startCountTime);
    }
}
