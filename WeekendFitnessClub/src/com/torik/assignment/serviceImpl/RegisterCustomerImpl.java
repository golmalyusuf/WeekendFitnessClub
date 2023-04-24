package com.torik.assignment.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.torik.assignment.bean.Customer;
import com.torik.assignment.service.RegisterCustomer;

public class RegisterCustomerImpl implements RegisterCustomer {

	@Override
	public int addCustomerToList(List<Customer> cutomerList) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please add new Customer Name:");
		String customerName = reader.readLine();
		
		System.out.println("Please add new Customer's mobile number: ");
		String customerMobileNumber = reader.readLine();
		
		Customer customer = new Customer(customerName, customerMobileNumber);
		int exists =  (int) cutomerList.stream().filter(x-> x.getCustomerName().equalsIgnoreCase(customerName) && x.getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber)).count();;
		if(exists == 0) {
			cutomerList.add(customer);
			System.out.println("Customer "+customerName+" Successfully Added!!!");
		} else {
			System.out.println("Customer "+customerName+" already exists!!!!");
		}
		
		cutomerList.forEach(x-> System.out.println(" Registered Customers "+x.getCustomerName()+"  "+x.getCusotmerMobileNo() ));
		return 1;
	}

	@Override 
	public void addCustomerToListWithName(List<Customer> cutomerList, String customerName, String customerMobileNumber) throws IOException {
		 
		 
		
		Customer customer = new Customer(customerName, customerMobileNumber);
		int exists =  (int) cutomerList.stream().filter(x-> x.getCustomerName().equalsIgnoreCase(customerName) && x.getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber)).count();;
		if(exists == 0) {
			cutomerList.add(customer);
			System.out.println("Customer "+customerName+" Successfully Added!!!");
		} else {
			System.out.println("Customer "+customerName+" already exists!!!!");
		}
		
		cutomerList.forEach(x-> System.out.println(" Registered Customers "+x.getCustomerName()+"  "+x.getCusotmerMobileNo() ));
		 
	}
}
