package com.torik.assignment.bean;

public class Rating {
	private Customer customer;
	private String lessonName;
	private int rating;
	private String lessonDate;

	public Rating(Customer customer, String lesson, int rating, String lessonDate) {
		this.customer = customer;
		this.lessonName = lessonName;
		this.rating = rating;
		this.lessonDate = lessonDate;
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
}
