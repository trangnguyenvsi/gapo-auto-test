package gapo.pilot.auto2.constant;

public enum Timeout {
    VERY_SHORT_TIME(500),
    SHORT_TIME(1000),
    LONG_TIME(3000);

    //instance variable
    private final int timeout;

    Timeout(int timeout) {
        this.timeout = timeout;
    }

    public int getTimeOut() {
        return timeout;
    }
}
