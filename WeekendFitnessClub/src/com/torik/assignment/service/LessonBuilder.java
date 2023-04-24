package com.torik.assignment.service;

import java.util.Date;
import java.util.List;
import com.torik.assignment.bean.Lesson;

public interface LessonBuilder {
	public void setLessonName(String lessonName);

	public void setCapacityOfClass(int capacity);

	public void setNumberOfCustomer(int enrolledCustomer);

	public void setLessonDates(List<Date> listOfDates);

	public void setMaximumWeeklysession(int maxWeeklySession);

	public void setPrice(double lessonCost);

	public Lesson getLesson();
}
