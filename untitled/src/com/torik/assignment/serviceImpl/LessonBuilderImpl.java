package com.torik.assignment.serviceImpl;

import java.util.Date;
import java.util.List;

import com.torik.assignment.bean.Lesson;
import com.torik.assignment.service.LessonBuilder;

public class LessonBuilderImpl implements LessonBuilder {

	private Lesson lesson;

	

	public LessonBuilderImpl() {
		super();
		this.lesson =  new Lesson();
	}

	@Override
	public Lesson getLesson() {
		return this.lesson ;
	}

	@Override
	public void setLessonName(String lessonName) {
		this.lesson.setLessonName(lessonName);

	}

	@Override
	public void setCapacityOfClass(int capacity) {
		this.lesson.setCapacityOfClass(capacity);

	}

	@Override
	public void setNumberOfCustomer(int enrolledCustomer) {
		this.lesson.setNumOfCustomer(enrolledCustomer);

	}

	@Override
	public void setLessonDates(List<Date> listOfDates) {
		this.lesson.setLessionDates(listOfDates);

	}

	@Override
	public void setMaximumWeeklysession(int maxWeeklySession) {
		this.lesson.setMaxWeeklysession(maxWeeklySession);

	}

	@Override
	public void setPrice(double lessonCost) {
		this.lesson.setPrice(lessonCost);
	}

}
