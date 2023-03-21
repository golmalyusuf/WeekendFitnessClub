package com.torik.assignment.bean;

public class Customer {
	private String customerName;
	private String cusotmerMobileNo;

	public Customer(String customerName, String cusotmerMobileNo) {
		this.customerName = customerName;
		this.cusotmerMobileNo = cusotmerMobileNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCusotmerMobileNo() {
		return cusotmerMobileNo;
	}

	public void setCusotmerMobileNo(String cusotmerMobileNo) {
		this.cusotmerMobileNo = cusotmerMobileNo;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", cusotmerMobileNo=" + cusotmerMobileNo + "]";
	}

}
