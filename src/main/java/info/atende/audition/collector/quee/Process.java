package info.atende.audition.collector.quee;

import info.atende.audition.collector.AuditCollectorException;
import info.atende.audition.collector.AuditCollectorExceptionEvent;
import info.atende.audition.collector.AuditEventDAO;
import info.atende.audition.model.AuditEvent;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Giovanni Silva.
 */
@Component
public class Process implements MessageListener {
    private Logger logger = Logger.getLogger(Process.class);

    @Autowired
    private AuditEventDAO auditEventDAO;
    @Autowired
    private MessageConverter converter;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void onMessage(Message message) {
        try {
            AuditEvent event = (AuditEvent) converter.fromMessage(message);
            auditEventDAO.save(event);
        }catch(Exception ex){

            AuditCollectorException exceptionEvent = new AuditCollectorException("Não pode salvar AuditEvent", ex);

            publisher.publishEvent(new AuditCollectorExceptionEvent(exceptionEvent));
            // Return event to Queue
            throw exceptionEvent;
        }

    }
}
