package io.pivotal.pace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.pivotal.pace.model.ApprovalResponse;
import io.pivotal.pace.model.Profile;

@SpringBootApplication
public class SpringCloudContractClientApplication {

	private static final String LOAN_APPROVAL_SVC_URL = "http://localhost:6565/check/v1";
	private static RestTemplate restTemplate;
	
	@Autowired
	public SpringCloudContractClientApplication(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}
	
	public static ApprovalResponse sendRequestToLoanApprovalService(Profile profile) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		// tag::client_call_server[]
		ResponseEntity<ApprovalResponse> response =
				restTemplate.exchange(LOAN_APPROVAL_SVC_URL, HttpMethod.POST,
						new HttpEntity<>(profile, httpHeaders),
						ApprovalResponse.class);
		// end::client_call_server[]

		return response.getBody();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudContractClientApplication.class, args);
	}
}
