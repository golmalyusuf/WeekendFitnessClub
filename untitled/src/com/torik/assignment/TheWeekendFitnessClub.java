package com.torik.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.*;
import com.torik.assignment.serviceImpl.*;

public class TheWeekendFitnessClub {

	public static void main(String[] args) throws ParseException {

		System.out.println("Welcome to The Weekend Fitness Club");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int userInputForChoice = Integer.MAX_VALUE;
		List<Customer> customerList = new ArrayList<Customer>();
		List<Lesson> listOfLesson = new ArrayList<Lesson>();
		List<BookingOrder> listOfBooking = new ArrayList<BookingOrder>();
		List<Rating> listOfRating = new ArrayList<Rating>();
		SelectionOptions.getSelectionOptions();

		////////////TEST///////////////////////
		Customer c = new Customer("golam", "1234");
		Customer c2 = new Customer("yusuf", "1234");
		customerList.add(c);
		customerList.add(c2);

		String dateInString = "25/03/2023";
		String dateInString2 = "26/03/2023";

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse(dateInString);
		Date date2 = formatter.parse(dateInString2);

		Lesson l1 = new Lesson();
		l1.setCapacityOfClass(5);
		Date[] dateArr = {date, date2};

		l1.setLessionDates(Arrays.asList(dateArr) );
		l1.setPrice(100);
		l1.setLessonName("SPIN");
		l1.setMaxWeeklysession(4);
		l1.setNumOfCustomer(0);

		Lesson l2 = new Lesson();
		l2.setCapacityOfClass(5);
		l2.setLessionDates(Arrays.asList(dateArr) );
		l2.setPrice(100);
		l2.setLessonName("Yoga");
		l2.setMaxWeeklysession(4);
		l2.setNumOfCustomer(0);
		listOfLesson.add(l1);
		listOfLesson.add(l2);
		///////////////////////////////////////
		while (userInputForChoice != 0) {

			try {

				switch (userInputForChoice) {
					case 1:
						RegisterCustomer registerCustomer = new RegisterCustomerImpl();
						registerCustomer.addCustomerToList(customerList);
						SelectionOptions.getSelectionOptions();
						break;
	
					case 2:
						LessonBuilderDirector createLesson = new LessonBuilderDirectorImpl();
						createLesson.addLessonsToList(listOfLesson);
						SelectionOptions.getSelectionOptions();
						break;
	
					case 3:
						AtomicInteger count = new AtomicInteger(0);
						customerList.forEach(x -> System.out
								.println(("  "+count.incrementAndGet()) + "  	  " + x.getCustomerName() + "		    " + x.getCusotmerMobileNo()));
						SelectionOptions.getSelectionOptions();
						break;
					case 4:
						LessonBuilderDirector allLesson = new LessonBuilderDirectorImpl();
						allLesson.getAllLessons(listOfLesson);
						SelectionOptions.getSelectionOptions();
						break;
					case 5:
						SearchFitnessLesson searchFitnessLesson = new SearchFitnessLessonImpl();
						searchFitnessLesson.findFitnessLessonByName(listOfLesson);
						SelectionOptions.getSelectionOptions();
						break;
					case 6:
						SearchFitnessLesson searchFitnessLessonByWeekendName = new SearchFitnessLessonImpl();
						searchFitnessLessonByWeekendName.findFitnessLessonByWeekendName(listOfLesson);
						SelectionOptions.getSelectionOptions();
						break;
					case 7:
						CustomerBookingLesson customerBooking = new CustomerBookingLessonImpl();
						customerBooking.customerBookALesson(customerList, listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 8:
						CustomerBookingLesson customerCancelBooking = new CustomerBookingLessonImpl();
						customerCancelBooking.customerCancelBookBooking(customerList, listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 9:
						CustomerBookingLesson customerChangeBooking = new CustomerBookingLessonImpl();
						customerChangeBooking.customerChangeBookBooking(customerList, listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 10:
						CustomerBookingLesson customerShowAllBooking = new CustomerBookingLessonImpl();
						customerShowAllBooking.showAllBookBooking(listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 11:
						CustomerRating customerRating = new CustomerRatingImpl();
						customerRating.addCustomerRating(customerList, listOfLesson, listOfBooking, listOfRating);
						SelectionOptions.getSelectionOptions();
						break;
					case 12:
						LessonReports lessonReports = new LessonReportImpl();
						lessonReports.generateLessonReportWithRating(listOfLesson, listOfRating);
						SelectionOptions.getSelectionOptions();
						break;
					default:
						System.out.println("Please enter proper numeric value.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Enter Choice==>");
			try {
				userInputForChoice = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
