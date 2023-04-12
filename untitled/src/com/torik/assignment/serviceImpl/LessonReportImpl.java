package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.LessonReports;

import java.util.*;
import java.util.stream.Collectors;

public class LessonReportImpl implements LessonReports {
    @Override
    public void generateLessonReportWithRating(List<Lesson> listLesson, List<Rating> listRating) {
        listLesson.stream().forEach(lesson ->
        {
            listRating.stream().forEach(
                    rate -> System.out.println(rate.getLessonName()));

            double avgValue = listRating.stream().filter(
                            rate -> rate.getLessonName().equalsIgnoreCase(
                                    lesson.getLessonName())
                    ).mapToDouble(
                            rating -> rating.getRating())
                    .average().orElse(0.0);
            System.out.println("Lesson Name: " + lesson.getLessonName() + "  " + avgValue);
        });
    }

    @Override
    public void generateLessonReportBasedOnIncome(List<Lesson> listLesson, List<BookingOrder> listBookingOrder) {
        HashMap<String, Double> hmap = new HashMap<String, Double>();
        listLesson.stream().forEach(y -> {
            hmap.put(y.getLessonName(), (y.getNumOfCustomer() * y.getPrice()));

        });

        hmap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) ;


        hmap.forEach((x, y) -> System.out.println("Lesson " + x + "  Profit " + y));
    }
}
