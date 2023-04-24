package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.LessonReports;
import com.torik.assignment.service.SelectionOptions;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class LessonReportImplTest {

    List<Lesson> listOfLesson = new ArrayList<Lesson>();
    List<Customer> customerList = new ArrayList<Customer>();
    List<BookingOrder> bookingList = new ArrayList<BookingOrder>();
    List<Rating> ratingList = new ArrayList<Rating>();

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
        l1.setNumOfCustomer(2);

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

        BookingOrder bookingOrder2 = new BookingOrder();
        bookingOrder2.setCustomer(c2);
        List<Lesson> bookingLessonList2 = new ArrayList<>();
        bookingLessonList2.add(l1);
        bookingOrder2.setListLesson(bookingLessonList2);
        bookingList.add(bookingOrder2);

        Rating rating = new Rating(c, l1.getLessonName(), 5, "25/03/2023");
        Rating rating2 = new Rating(c2, l1.getLessonName(), 4, "25/03/2023");
        ratingList.add(rating);
        ratingList.add(rating2);
    }

    @Test
    public void generateLessonReportWithRating() throws ParseException {
        setTestCustomerAndLessonsAndBooking();
        LessonReports lessonReports = new LessonReportImpl();
        lessonReports.generateLessonReportWithRating(listOfLesson, ratingList);

    }

    @Test
    public void generateLessonReportBasedOnIncome() throws ParseException {
        setTestCustomerAndLessonsAndBooking();
        LessonReports lessonReportsWithProfit = new LessonReportImpl();
        bookingList.forEach(x-> System.out.println(x.getCustomer().getCustomerName()+"  "+x.getListLesson().toString()));
        lessonReportsWithProfit.generateLessonReportBasedOnIncome(listOfLesson, bookingList);
    }
}