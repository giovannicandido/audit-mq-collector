package br.pucminas.icei.audition;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Giovanni Silva.
 */
@Component
public class ExceptionHandlerCenter {
    @Value("${audit.max-queue-exception:10}")
    private Integer maxThreshold = 10;
    @Value("${queue-reconnect-time-out:30}")
    private Integer containerTimeOut=30;
    @Autowired
    private SimpleMessageListenerContainer container;
    private AtomicInteger count = new AtomicInteger(0);

    @Autowired
    private TaskScheduler taskScheduler;

    private Logger logger = Logger.getLogger(ExceptionHandlerCenter.class);

    @EventListener
    public void auditCollectorExceptionHandler(AuditCollectorExceptionEvent event){
        Integer atual = count.incrementAndGet();
        logger.info("Tentativa " + atual);
        logger.error(event.getException().getCause().getMessage());
        if(atual >= maxThreshold && container.isRunning()){
            // TODO Send Email to responsible person
            logger.info("Sending email - Limit of exceptions in the queue reached");
            container.stop();
            count.set(0);
            scheduleStartOfContainer(containerTimeOut);
        }

    }

    private void scheduleStartOfContainer(int seconds) {
        LocalDateTime afterMinutes = LocalDateTime.now().plusSeconds(seconds);
        Instant instant = afterMinutes.atZone(ZoneId.systemDefault()).toInstant();
        Date afterMinutesDate = Date.from(instant);
        logger.info("MessageListenerContainer volta em " + seconds + " segundos. Data:  " + afterMinutes.toString() );
        taskScheduler.schedule(new StartContainerTask(container),  afterMinutesDate);
    }

    private class StartContainerTask implements Runnable {
        private SimpleMessageListenerContainer container;

        public StartContainerTask(SimpleMessageListenerContainer container) {
            this.container = container;
        }

        @Override
        public void run() {
            container.start();
        }
    }
}
