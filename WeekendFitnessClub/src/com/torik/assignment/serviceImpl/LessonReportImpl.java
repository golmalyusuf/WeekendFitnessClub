package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.LessonReports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class LessonReportImpl implements LessonReports {
    @Override
    public void generateLessonReportWithRating(List<Lesson> listLesson, List<Rating> listRating) {
        listLesson.stream().forEach(lesson ->
        {

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
            hmap.put(y.getLessonName(), (y.getNumOfCustomer() * y.getPrice() * y.getLessonDates().size()));

        });

        LinkedHashMap<String, Double> sortedMap = hmap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


       // sortedMap.forEach((x, y) -> System.out.println("Lesson " + x + "  Profit " + y));
        Map.Entry<String,Double> entry = sortedMap.entrySet().iterator().next();
        String key = entry.getKey();
        double value = entry.getValue();
        System.out.println("Highest profitable lesson is " + key + " and net  profit " + value);
    }

    @Override
    public void generateLessonReportBasedOnMonthlyIncome(List<Lesson> listOfLesson, List<BookingOrder> listOfBooking) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please Enter Month Number (00 for January, 01 for February, 02 for March, 03 for April ...): ");
        String strMonthNumber = reader.readLine();

        int monthNumber = Integer.parseInt(strMonthNumber);
        HashMap<String, Double> hmap = new HashMap<String, Double>();
        listOfLesson.stream().forEach(y -> {
            List<Date> listOfdatesForMonth = y.getLessonDates().stream()
                    .filter(date -> {
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        return cal.get(Calendar.MONTH) == monthNumber ;
                    })
                    .collect(Collectors.toList());

            hmap.put(y.getLessonName(), (y.getNumOfCustomer() * y.getPrice() * listOfdatesForMonth.size()));

        });

//        hmap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        LinkedHashMap<String, Double> sortedMap = hmap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        sortedMap.forEach((x, y) -> System.out.println("Lesson " + x + "  Profit " + y));

    }


}
