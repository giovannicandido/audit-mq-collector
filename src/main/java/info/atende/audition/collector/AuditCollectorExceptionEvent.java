package info.atende.audition.collector;

/**
 * @author Giovanni Silva.
 */
public class AuditCollectorExceptionEvent {

    private final AuditCollectorException exception;

    public AuditCollectorExceptionEvent(AuditCollectorException exception) {
        this.exception = exception;
    }

    public AuditCollectorException getException() {
        return exception;
    }
}
