package retostarter.retostarter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("nextstatus.status")
public class StatusProperties {
	
	private String status = "close";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
