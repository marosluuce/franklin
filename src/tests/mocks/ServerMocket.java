package tests.mocks;

public class ServerMocket {
    private Mocket mocket;
    private boolean closed = false;
    private int maxConnections;

    public ServerMocket(Mocket mocket) {
        this(mocket, -1);
    }

    public ServerMocket(Mocket mocket, int maxConnections) {
        this.mocket = mocket;
        this.maxConnections = maxConnections;
    }

    public Mocket accept() {
        countdownAndClose();
        return mocket;
    }

    public void close() {
        closed = true;
    }

    public boolean isBound() {
        return true;
    }

    public boolean isClosed() {
        return closed;
    }

    private void countdownAndClose() {
        if (maxConnections > 0) {
            maxConnections--;
        }
        if (maxConnections == 0) {
            close();
        }
    }
}
