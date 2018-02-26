package io.pivotal.pace.model;

public class ApprovalResponse {

	private String status;
	
	public ApprovalResponse() {
		
	}

	public ApprovalResponse(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
