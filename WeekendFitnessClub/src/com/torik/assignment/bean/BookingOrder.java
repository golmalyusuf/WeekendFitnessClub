package com.torik.assignment.bean;

import java.util.List;

public class BookingOrder {

	private Customer customer;
	private List<Lesson> listLesson;

	public BookingOrder() {
		super();
	}

	public BookingOrder(Customer customer, List<Lesson> listLesson) {
		super();
		this.customer = customer;
		this.listLesson = listLesson;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Lesson> getListLesson() {
		return listLesson;
	}

	public void setListLesson(List<Lesson> listLesson) {
		this.listLesson = listLesson;
	}

}
