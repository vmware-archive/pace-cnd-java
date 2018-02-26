package io.pivotal.pace.loan;

import org.junit.Before;

import io.pivotal.pace.ApprovalController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class LoanRestBase {

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new ApprovalController());
	}

}
