package com.torik.assignment.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.torik.assignment.bean.Lesson;
import com.torik.assignment.service.LessonBuilder;
import com.torik.assignment.service.LessonBuilderDirector;

public class LessonBuilderDirectorImpl implements LessonBuilderDirector {

	@Override
	public void addLessonsToList(List<Lesson> listOfLesson) throws IOException, ParseException {
		int capacityOfClass = 5;
		int numberOfEnrolledCustomer = 0;
		int maxWeeklysession = 4;
		List<Date> listOfDatesLocal = new ArrayList<Date>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.println("Please choose a Lesson Name from the list: " + java.util.Arrays.asList(LessonType.values()));

		String lessonName = reader.readLine();
		System.out.println("Please insert dates in dd/MM/yyyy format and if you are done insert number Zero (0)");
		while (true) {

			String lessonDate = reader.readLine();

			if (!lessonDate.equals("0")) {
				Calendar calender = Calendar.getInstance();
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(lessonDate);
				calender.setTime(date1);
				if (calender.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
						|| calender.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					listOfDatesLocal.add(date1);
				} else {
					System.out.println("Wrong date inserted. Please enter a valid weekend date!!!!");
				}
			} else {
				break;
			}
		}

		System.out.println("Please Enter Lesson Price For " + lessonName);
		double lessonPrice = Double.parseDouble(reader.readLine());

		LessonBuilder lessonBuilder = new LessonBuilderImpl();
		lessonBuilder.getLesson();
		lessonBuilder.setLessonName(lessonName);
		lessonBuilder.setCapacityOfClass(capacityOfClass);
		lessonBuilder.setMaximumWeeklysession(maxWeeklysession);
		lessonBuilder.setPrice(lessonPrice);
		lessonBuilder.setLessonDates(listOfDatesLocal);
		lessonBuilder.setNumberOfCustomer(numberOfEnrolledCustomer);

		 
		int count = (int) listOfLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonName)).count();
		if (count == 0) {
			listOfLesson.add(lessonBuilder.getLesson());
		}
	}

	@Override
	public void getAllLessons(List<Lesson> listOfLesson) {
		AtomicInteger countLessons = new AtomicInteger(0);
		listOfLesson.forEach(x -> {
			System.out.println(("  " + countLessons.incrementAndGet()) + "  	  Lesson Name: " + x.getLessonName());
			System.out.println("             Lesson Price: " + x.getPrice());
			System.out.println("             Class Capacity: " + x.getCapacityOfClass());
			System.out.println("             Number of Enrolled Customers: " + x.getNumOfCustomer());
			System.out.println("             Class Dates are as following: ");
			x.getLessonDates().forEach(
					data -> System.out.println("                " + new SimpleDateFormat("dd/MM/yyyy").format(data)));
		});

	}

}
