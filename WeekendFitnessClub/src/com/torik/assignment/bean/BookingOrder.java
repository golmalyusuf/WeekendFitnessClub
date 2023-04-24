package com.torik.assignment.bean;

import java.util.List;
import java.util.Map;

public class BookingOrder {

	private Customer customer;
	private List<Lesson> listLesson;
	private Map<String, String> statusMap;

	public BookingOrder() {
		super();
	}

	/*public BookingOrder(Customer customer, List<Lesson> listLesson) {
		super();
		this.customer = customer;
		this.listLesson = listLesson;
	}*/

	public BookingOrder(Customer customer, List<Lesson> listLesson, Map<String, String> statusMap) {
		this.customer = customer;
		this.listLesson = listLesson;
		this.statusMap = statusMap;
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

	public Map<String, String> getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map<String, String> statusMap) {
		this.statusMap = statusMap;
	}
}
