import java.net.InetSocketAddress;

public final class LogEvent {
    public static final byte SEPARATOR = (byte) ':';
    private final InetSocketAddress source;
    private final String logfile;
    private final String message;
    private final long received;

    public LogEvent(String logfile, String message) {
        this(null, -1, logfile, message);
    }

    public LogEvent(InetSocketAddress source, long received, String logfile, String message) {
        this.source = source;
        this.logfile = logfile;
        this.message = message;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMessage() {
        return message;
    }

    public long getReceivedTimestamp() {
        return received;
    }
}
