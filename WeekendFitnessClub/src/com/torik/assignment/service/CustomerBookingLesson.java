package com.torik.assignment.service;

import java.io.IOException;
import java.util.List;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;

public interface CustomerBookingLesson {

	public void customerBookALesson(List<Customer> listCustomer, List<Lesson> listLesson,
			List<BookingOrder> bookingList) throws IOException;

	public void customerCancelBookBooking(List<Customer> listCustomer, List<Lesson> listLesson,
			List<BookingOrder> bookingList) throws IOException;

	public void customerChangeBookBooking(List<Customer> listCustomer, List<Lesson> listLesson,
			List<BookingOrder> bookingList) throws IOException;
	
	public void showAllBooking(List<BookingOrder> bookingList) throws IOException;


	void setCustomerAttendanceModification(List<Customer> customerList, List<Lesson> listOfLesson, List<BookingOrder> listOfBooking) throws IOException;
}
