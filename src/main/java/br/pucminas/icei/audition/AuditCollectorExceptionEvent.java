package br.pucminas.icei.audition;

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
