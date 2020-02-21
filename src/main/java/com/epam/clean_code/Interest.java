package com.epam.clean_code;

public class Interest {
	private float interestRate;
	private float principal;
	private int totalTime;
	private int compoundingTimeInYears;
	
	public Interest(float interestRate, float principal, int totalTime) {
		this.interestRate = interestRate;
		this.principal = principal;
		this.totalTime = totalTime;
	}
	public Interest(float interestRate, float principal, int totalTime, int compoundingTimeInYears) {
		this.interestRate = interestRate;
		this.principal = principal;
		this.totalTime = totalTime;
		this.compoundingTimeInYears = compoundingTimeInYears;
	}
	public float calculateSimpleInterest() {
		float amount, simpleInterest;
		amount = this.principal * (1 + ((this.interestRate/100) * this.totalTime));
		simpleInterest = amount - this.principal;
		return simpleInterest;
	}
	
	public float calculateCompoundInterest() {
		float amount, compoundInterest;
		amount =  (float) (this.principal * Math.pow(1 + ((this.interestRate/100)/this.compoundingTimeInYears), (this.compoundingTimeInYears * totalTime)));
		compoundInterest = amount - this.principal; 
		return compoundInterest;
	}
}
