package io.pivotal.pace.model;

import java.math.BigDecimal;

public class Profile {

	private BigDecimal income;
	private BigDecimal loanAmount;
	
	public Profile() {
		
	}
	
	public Profile(double income, double loanAmount) {
		this.income = BigDecimal.valueOf(income);
		this.loanAmount = BigDecimal.valueOf(loanAmount);
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	
}
