package info.atende.audition.collector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ActiveProfiles;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuditMQCollector.class)
public class AuditiMQCollectorTests {

	@Test
	public void contextLoads() {
	}

}
