package com.torik.assignment.bean;

import java.util.Date;
import java.util.List;

import com.torik.assignment.serviceImpl.LessonType;

public class Lesson {

	private String lessonName;
	private int capacityOfClass;
	private int numOfCustomer;
	private List<Date> lessonDates;
	private int maxWeeklysession;
	private double price;

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public void setLessonDates(List<Date> lessonDates) {
		this.lessonDates = lessonDates;
	}

	public void setCapacityOfClass(int capacityOfClass) {
		this.capacityOfClass = capacityOfClass;
	}

	public void setNumOfCustomer(int numOfCustomer) {
		this.numOfCustomer = numOfCustomer;
	}

	public void setLessionDates(List<Date> lessonDates) {
		this.lessonDates = lessonDates;
	}

	public void setMaxWeeklysession(int maxWeeklysession) {
		this.maxWeeklysession = maxWeeklysession;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLessonName() {
		return lessonName;
	}

	public int getCapacityOfClass() {
		return capacityOfClass;
	}

	public int getNumOfCustomer() {
		return numOfCustomer;
	}

	public List<Date> getLessonDates() {
		return lessonDates;
	}

	public int getMaxWeeklysession() {
		return maxWeeklysession;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Lesson [lessonName=" + lessonName + ", capacityOfClass=" + capacityOfClass + ", numOfCustomer="
				+ numOfCustomer + ", lessonDates=" + lessonDates + ", maxWeeklysession=" + maxWeeklysession + ", price="
				+ price + "]";
	}

}
