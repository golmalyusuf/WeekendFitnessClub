package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.service.CustomerBookingLesson;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerBookingLessonImplTest {

    List<Lesson> listOfLesson = new ArrayList<Lesson>();
    List<Customer> customerList = new ArrayList<Customer>();
    private void setTestCustomerAndLessons() throws ParseException {
        Customer c = new Customer("John", "1234567890");
        Customer c2 = new Customer("Torik", "1234567890");
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
        l2.setLessonName("YOGA");
        l2.setMaxWeeklysession(4);
        l2.setNumOfCustomer(0);
        listOfLesson.add(l1);
        listOfLesson.add(l2);
    }
    @Test
    public void customerBookALesson() throws IOException, ParseException {
        setTestCustomerAndLessons();
        String input = "John\n1234567890\nSPIN"; // example input with name and mobile number
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<BookingOrder> listOfBooking = new ArrayList<>();
        CustomerBookingLesson customerBooking = new CustomerBookingLessonImpl();
        customerBooking.customerBookALesson(customerList, listOfLesson, listOfBooking);
        System.out.println(listOfBooking.size());
    }

    @Test
    public void customerCancelBookBooking() throws ParseException, IOException {
        setTestCustomerAndLessons();
        String input = "John\n1234567890\nSPIN";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<BookingOrder> listOfBooking = new ArrayList<>();
        CustomerBookingLesson customerCancelBooking = new CustomerBookingLessonImpl();
        customerCancelBooking.customerBookALesson(customerList, listOfLesson, listOfBooking);

        String cancelBooking = "John\n1234567890\nSPIN";
        InputStream inputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream2);
        customerCancelBooking.customerCancelBookBooking(customerList, listOfLesson, listOfBooking);
    }

    @Test
    public void customerChangeBookBooking() throws IOException, ParseException {
        setTestCustomerAndLessons();
        String input = "John\n1234567890\nSPIN";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<BookingOrder> listOfBooking = new ArrayList<>();
        CustomerBookingLesson customerChangeBooking = new CustomerBookingLessonImpl();
        customerChangeBooking.customerBookALesson(customerList, listOfLesson, listOfBooking);

        String cancelBooking = "John\n1234567890\nYOGA\nYOGA";
        InputStream inputStream2 = new ByteArrayInputStream(cancelBooking.getBytes());
        System.setIn(inputStream2);
        customerChangeBooking.customerChangeBookBooking(customerList, listOfLesson, listOfBooking);
    }

    @Test
    public void showAllBookBooking() throws ParseException, IOException {

        setTestCustomerAndLessons();
        String input = "John\n1234567890\nSPIN";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<BookingOrder> listOfBooking = new ArrayList<>();
        CustomerBookingLesson customerChangeBooking = new CustomerBookingLessonImpl();
        customerChangeBooking.customerBookALesson(customerList, listOfLesson, listOfBooking);

        input = "Torik\n1234567890\nYOGA";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        customerChangeBooking.customerBookALesson(customerList, listOfLesson, listOfBooking);


        CustomerBookingLesson customerBookings = new CustomerBookingLessonImpl();
        customerBookings.showAllBookBooking(listOfBooking);
    }
}