package com.paymentus.model;

public class OperationDetail {
	
	private Float value;
	private int afterRounding;
	private Float difference;
	
	public OperationDetail() {
		
	}
	
	public OperationDetail(Float value, int afterRounding, Float difference) {
		super();
		this.value = value;
		this.afterRounding = afterRounding;
		this.difference = difference;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public int getAfterRounding() {
		return afterRounding;
	}
	public void setAfterRounding(int nearestInt) {
		this.afterRounding = nearestInt;
	}
	public Float getDifference() {
		return difference;
	}
	public void setDifference(Float difference) {
		this.difference = difference;
	}
	
	

}
