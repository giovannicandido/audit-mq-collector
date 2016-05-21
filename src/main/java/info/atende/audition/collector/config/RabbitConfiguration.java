package info.atende.audition.collector.config;

import info.atende.audition.collector.quee.Process;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Giovanni Silva.
 */
@Configuration
@EnableRabbit
public class RabbitConfiguration {
    @Value("${audit.queue.name}")
    String queueName = "auditLog";

    @Autowired
    Process process;
    @Autowired
    ConnectionFactory connectionFactory;


    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(process);
        return container;
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        converter.setJsonObjectMapper(mapper);
        return converter;
    }
    @Bean
    public RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setRoutingKey(queueName);
        template.setMessageConverter(converter);
        return template;
    }
}
