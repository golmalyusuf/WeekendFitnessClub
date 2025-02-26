package com.torik.assignment.bean;

public class Rating {
	private Customer customer;
	private String lessonName;
	private int rating;
	private String lessonDate;
	private String customerReview;

	public Rating(Customer customer, String lessonName, int rating, String lessonDate) {
		this.customer = customer;
		this.lessonName = lessonName;
		this.rating = rating;
		this.lessonDate = lessonDate;
	}

	public Rating(Customer customer, String lessonName, int rating, String lessonDate, String customerReview) {
		this.customer = customer;
		this.lessonName = lessonName;
		this.rating = rating;
		this.lessonDate = lessonDate;
		this.customerReview = customerReview;
	}

	public Customer getCustoemr() {
		return customer;
	}

	public void setCustoemr(Customer customer) {
		this.customer = customer;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getLessonDate() {
		return lessonDate;
	}

	public void setLessonDate(String lessonDate) {
		this.lessonDate = lessonDate;
	}

	public String getCustomerReview() {
		return customerReview;
	}

	public void setCustomerReview(String customerReview) {
		this.customerReview = customerReview;
	}
}
