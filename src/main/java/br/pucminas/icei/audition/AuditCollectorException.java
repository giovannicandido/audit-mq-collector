package br.pucminas.icei.audition;

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
