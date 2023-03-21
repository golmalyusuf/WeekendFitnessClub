package com.torik.assignment.bean;

public class Rating {
	private Customer custoemr;
	private Lesson lesson;
	private int rating;

	public Customer getCustoemr() {
		return custoemr;
	}

	public void setCustoemr(Customer custoemr) {
		this.custoemr = custoemr;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
