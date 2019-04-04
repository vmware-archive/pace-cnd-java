package io.pivotal.pace;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.pace.model.ApprovalResponse;
import io.pivotal.pace.model.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"pace.pivotal.io:spring-cloud-contract:+:stubs:6565"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@DirtiesContext

public class LoanApprovalTests {

	@Autowired
	ObjectMapper objectMapper;

	
	@Test 
	public void should_approve_loan_if_income_sufficient() throws Exception {
		
		// given:
		Profile profile = new Profile(50000, 10000);
	    // when:
		ApprovalResponse approvalResponse = SpringCloudContractClientApplication.sendRequestToLoanApprovalService(profile);
		// then:
		assertThat(approvalResponse.getStatus()).isEqualTo("APPROVED");
		
	}

	@Test 
	public void should_deny_loan_if_income_insufficient() throws Exception {

		// given:
		Profile profile = new Profile(50000, 20000);
	    // when:
		ApprovalResponse approvalResponse = SpringCloudContractClientApplication.sendRequestToLoanApprovalService(profile);
		// then:
		assertThat(approvalResponse.getStatus()).isEqualTo("DENIED");
		
	}
}
