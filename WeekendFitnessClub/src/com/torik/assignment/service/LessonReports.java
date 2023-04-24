package com.torik.assignment.service;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;

import java.io.IOException;
import java.util.List;

public interface LessonReports {
    public void generateLessonReportWithRating(List<Lesson> listLesson, List<Rating> listRating);
    public void generateLessonReportBasedOnIncome(List<Lesson> listLesson, List<BookingOrder> listBookingOrder);

    void generateLessonReportBasedOnMonthlyIncome(List<Lesson> listOfLesson, List<BookingOrder> listOfBooking) throws IOException;
}
