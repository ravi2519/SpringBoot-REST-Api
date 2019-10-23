package com.paymentus.model;

import java.util.List;

public class FundInputs {
	
	private List<Float> values;
	private Float initialFund;
	
	public FundInputs() {
		
	}
	
	public FundInputs(List<Float> values, Float initialFund) {
		this.values = values;
		this.initialFund = initialFund;
	}

	public List<Float> getValues() {
		return this.values;
	}

	public Float getInitialFund() {
		return this.initialFund;
	}
	
	
}
