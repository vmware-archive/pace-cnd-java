package io.pivotal.pace;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.pace.model.ApprovalResponse;
import io.pivotal.pace.model.Profile;

@RestController
public class ApprovalController {

	private static final double MAX_LOAN_RATIO = 0.3;
	
	public ApprovalController() {
		
	}
	
	@RequestMapping(value="/check/v1", method=RequestMethod.POST)
	public ApprovalResponse getLoanApproval(@RequestBody Profile profile) {
		
		ApprovalResponse approvalResponse = new ApprovalResponse();
		double loanToIncomeRatio = profile.getLoanAmount().doubleValue() / profile.getIncome().doubleValue();
		
		if (loanToIncomeRatio<=MAX_LOAN_RATIO)
			approvalResponse.setStatus("APPROVED");
		else
			approvalResponse.setStatus("DENIED");
			
		return approvalResponse;
		
	}
}
