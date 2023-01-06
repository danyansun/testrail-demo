package foodtruck.util;

/**
 * @author Michelle
 */
public final class StopWatch {
    private long start;

    public StopWatch() {
        reset();
    }

    public void reset() {
        start = System.nanoTime();
    }

    public long elapsed() {
        long end = System.nanoTime();
        return end - start;
    }
}
