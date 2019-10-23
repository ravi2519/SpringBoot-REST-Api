package com.paymentus.model;

import java.util.List;

public class RoundedFunds {
	
	private List<OperationDetail> roundedDown;
	private List<OperationDetail> roundedUp;
	private Float remainingFund;
	
	public RoundedFunds() {
		
	}
	public RoundedFunds(List<OperationDetail> roundedDown, List<OperationDetail> roundedUp, Float remainingFund) {
		super();
		this.roundedDown = roundedDown;
		this.roundedUp = roundedUp;
		this.remainingFund = remainingFund;
	}
	public List<OperationDetail> getRoundedDown() {
		return roundedDown;
	}
	public void setRoundedDown(List<OperationDetail> roundedDown) {
		this.roundedDown = roundedDown;
	}
	public List<OperationDetail> getRoundedUp() {
		return roundedUp;
	}
	public void setRoundedUp(List<OperationDetail> roundedUp) {
		this.roundedUp = roundedUp;
	}
	public Float getRemainingFund() {
		return remainingFund;
	}
	public void setRemainingFund(Float remainingFund) {
		this.remainingFund = remainingFund;
	}
}
