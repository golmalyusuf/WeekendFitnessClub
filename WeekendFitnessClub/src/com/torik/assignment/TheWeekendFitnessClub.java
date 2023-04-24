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

		////////////TEST Data for Demo///////////////////////
		Customer c = new Customer("Torik", "1234");
		Customer c2 = new Customer("John", "12345");
		Customer c3 = new Customer("Kim", "1233");
		customerList.add(c);
		customerList.add(c2);
		customerList.add(c3);

		String dateInString1 = "11/03/2023";
		String dateInString2 = "12/03/2023";
		String dateInString3 = "18/03/2023";
		String dateInString4 = "19/03/2023";
		String dateInString5 = "25/03/2023";
		String dateInString6 = "26/03/2023";
		String dateInString7 = "01/04/2023";
		String dateInString8 = "02/04/2023";
		String dateInString9 = "08/04/2023";
		String dateInString10 = "09/04/2023";
		String dateInString11 = "15/04/2023";
		String dateInString12 = "16/04/2023";
		String dateInString13 = "22/04/2023";
		String dateInString14 = "23/04/2023";

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = formatter.parse(dateInString1);
		Date date2 = formatter.parse(dateInString2);
		Date date3 = formatter.parse(dateInString3);
		Date date4 = formatter.parse(dateInString4);
		Date date5 = formatter.parse(dateInString5);
		Date date6 = formatter.parse(dateInString6);
		Date date7 = formatter.parse(dateInString7);
		Date date8 = formatter.parse(dateInString8);
		Date date9 = formatter.parse(dateInString9);
		Date date10 = formatter.parse(dateInString10);
		Date date11 = formatter.parse(dateInString11);
		Date date12 = formatter.parse(dateInString12);
		Date date13= formatter.parse(dateInString13);
		Date date14 = formatter.parse(dateInString14);

		Lesson l1 = new Lesson();
		l1.setCapacityOfClass(5);
		Date[] dateArr = {date7,date8, date9,date10, date11,date12, date13,date14};

		l1.setLessionDates(Arrays.asList(dateArr) );
		l1.setPrice(100);
		l1.setLessonName("SPIN");
		l1.setMaxWeeklysession(4);
		l1.setNumOfCustomer(1);

		Lesson l2 = new Lesson();
		l2.setCapacityOfClass(5);
		l2.setLessionDates(Arrays.asList(dateArr) );
		l2.setPrice(120);
		l2.setLessonName("Yoga");
		l2.setMaxWeeklysession(4);
		l2.setNumOfCustomer(1);
		listOfLesson.add(l1);
		listOfLesson.add(l2);

		BookingOrder bookingOrder = new BookingOrder();
		bookingOrder.setCustomer(c);
		List<Lesson> forCustomerCLessonList = new ArrayList<>();
		forCustomerCLessonList.add(l1);
		bookingOrder.setListLesson(forCustomerCLessonList);
		Map<String, String> statusMap1 = new HashMap<String,String>();
		statusMap1.put(l1.getLessonName(), "Booked");
		bookingOrder.setStatusMap(statusMap1);

		BookingOrder bookingOrder2 = new BookingOrder();
		bookingOrder2.setCustomer(c2);
		List<Lesson> forCustomerCLessonList2 = new ArrayList<>();
		forCustomerCLessonList2.add(l2);
		bookingOrder2.setListLesson(forCustomerCLessonList2);
		Map<String, String> statusMap2 = new HashMap<String,String>();
		statusMap2.put(l2.getLessonName(), "Booked");
		bookingOrder2.setStatusMap(statusMap2);

		listOfBooking.add(bookingOrder);
		listOfBooking.add(bookingOrder2);
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
						CustomerBookingLesson customerAttendanceModification = new CustomerBookingLessonImpl();
						customerAttendanceModification.setCustomerAttendanceModification(customerList, listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 9:
						CustomerBookingLesson customerCancelBooking = new CustomerBookingLessonImpl();
						customerCancelBooking.customerCancelBookBooking(customerList, listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 10:
						CustomerBookingLesson customerChangeBooking = new CustomerBookingLessonImpl();
						customerChangeBooking.customerChangeBookBooking(customerList, listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 11:
						CustomerBookingLesson customerShowAllBooking = new CustomerBookingLessonImpl();
						customerShowAllBooking.showAllBooking(listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 12:
						CustomerRating customerRating = new CustomerRatingImpl();
						customerRating.addCustomerRating(customerList, listOfLesson, listOfBooking, listOfRating);
						SelectionOptions.getSelectionOptions();
						break;
					case 13:
						LessonReports lessonReports = new LessonReportImpl();
						lessonReports.generateLessonReportWithRating(listOfLesson, listOfRating);
						SelectionOptions.getSelectionOptions();
						break;
					case 14:
						LessonReports lessonReportsWithProfitMonthly = new LessonReportImpl();
						lessonReportsWithProfitMonthly.generateLessonReportBasedOnMonthlyIncome(listOfLesson, listOfBooking);
						SelectionOptions.getSelectionOptions();
						break;
					case 15:
						LessonReports lessonReportsWithProfit = new LessonReportImpl();
						lessonReportsWithProfit.generateLessonReportBasedOnIncome(listOfLesson, listOfBooking);
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
