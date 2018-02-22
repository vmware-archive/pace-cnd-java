package io.pivotal.pace;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.pace.model.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"pace.pivotal.io:spring-cloud-contract:+:stubs:6565"}, workOffline = true)
@DirtiesContext

public class LoanApprovalTests {

	@Autowired
	ObjectMapper objectMapper;
	
	private MockMvc mockMvc;
	
	@Test public void should_approve_loan_if_income_sufficient() throws Exception {
		//remove::start[]
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/check")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new Profile(50000, 10000))))
				.andExpect(status().isOk())
				.andExpect(content().string("{ \"status\" : \"APPROVED\" }"));
		//remove::end[]
	}

	@Test public void should_deny_loan_if_income_insufficient() throws Exception {
		//remove::start[]
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/check")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new Profile(50000, 20000))))
				.andExpect(status().isOk())
				.andExpect(content().string("{ \"status\" : \"DENIED\" }"));
		//remove::end[]
	}
}
