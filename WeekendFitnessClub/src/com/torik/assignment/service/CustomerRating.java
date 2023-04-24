package com.torik.assignment.service;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface CustomerRating {
    public void addCustomerRating(List<Customer> listCustomer, List<Lesson> listLesson,
                                  List<BookingOrder> bookingList , List<Rating> listOfRating) throws IOException, ParseException;
}
