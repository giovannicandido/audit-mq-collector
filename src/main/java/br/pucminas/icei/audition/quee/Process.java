package br.pucminas.icei.audition.quee;

import br.pucminas.icei.audition.AuditEventDAO;
import br.pucminas.icei.audition.entity.AuditEvent;
import br.pucminas.icei.audition.entity.SecurityLevel;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Giovanni Silva.
 */
@Component
public class Process implements MessageListener {
    private Logger logger = Logger.getLogger(Process.class);

    @Autowired
    AuditEventDAO auditEventDAO;

    @Override
    public void onMessage(Message message) {
        AuditEvent event = new AuditEvent("Test", "Test", "Ação de teste", LocalDateTime.now(),
                "10.0.4.2", SecurityLevel.NORMAL);
        auditEventDAO.save(event);
    }
}
