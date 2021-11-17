package retostarter.retostarter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Status.class)
@EnableConfigurationProperties(StatusProperties.class)
public class StatusAutoConfigure {

	private final StatusProperties properties;

	public StatusAutoConfigure(StatusProperties properties) {
		this.properties = properties;
	}

	@Bean
	public Status getStatus() {
		System.out.println("Status: "+properties.getStatus());
		return new Status(properties.getStatus());
	}

}
