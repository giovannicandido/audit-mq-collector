package info.atende.audition.collector;

/**
 * @author Giovanni Silva.
 */
public class AuditCollectorException extends RuntimeException {
    public AuditCollectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuditCollectorException(String message) {
        super(message);
    }
}
