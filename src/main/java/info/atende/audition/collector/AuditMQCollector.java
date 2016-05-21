package info.atende.audition.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AuditMQCollector {

	public static void main(String[] args) {
		SpringApplication.run(AuditMQCollector.class, args);
	}
}
