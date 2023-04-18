package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.CustomerRating;
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

public class CustomerRatingImplTest {
    List<Lesson> listOfLesson = new ArrayList<Lesson>();
    List<Customer> customerList = new ArrayList<Customer>();
    List<BookingOrder> bookingList = new ArrayList<BookingOrder>();

    private void setTestCustomerAndLessonsAndBooking() throws ParseException {
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

        BookingOrder bookingOrder = new BookingOrder();
        bookingOrder.setCustomer(c);
        List<Lesson> bookingLessonList = new ArrayList<>();
        bookingLessonList.add(l1);
        bookingOrder.setListLesson(bookingLessonList);
        bookingList.add(bookingOrder);
    }

    @Test
    public void addCustomerRating() throws ParseException, IOException {
        setTestCustomerAndLessonsAndBooking();
        String input = "John\n1234567890\nSPIN\n25/03/2023\n5"; // example input with name and mobile number
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<Rating> listOfRating = new ArrayList<>();
        CustomerRating customerRating = new CustomerRatingImpl();
        customerRating.addCustomerRating(customerList, listOfLesson, bookingList, listOfRating);
        int size = listOfRating.size();
        assertEquals(1, size);
    }
}