package retostarter.retostarter.configuration;

import java.util.ArrayList;
import java.util.List;

public class Status {
	private String status;

	public Status(String status) {
		this.status = status;
	}


	public List<String> nextStatus(String status) {
		List<String> statusList = new ArrayList<>();
		String nextStatus = "";
		switch (status) {
		case "open":
			nextStatus = "close";
			statusList.add(nextStatus);
			break;
			
		case "close":
			nextStatus = "half-open";
			statusList.add(nextStatus);
			break;
			
		case "half-open":
			nextStatus = "open";
			statusList.add(nextStatus);
			break;
		
		default:
			nextStatus = "close";
			statusList.add(nextStatus);
			break;
		}
		
		
		return statusList;
	}
	
}
