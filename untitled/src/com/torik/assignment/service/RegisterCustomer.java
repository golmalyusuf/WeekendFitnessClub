package com.torik.assignment.service;

import java.io.IOException;
import java.util.List;

import com.torik.assignment.bean.Customer;

public interface RegisterCustomer {
	
	public int addCustomerToList(List<Customer> customerList) throws IOException;

	public void addCustomerToListWithName(List<Customer> cutomerList, String customerName, String customerMobileNumber)
			throws IOException;
 
}
