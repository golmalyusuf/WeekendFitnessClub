package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.CustomerRating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CustomerRatingImpl implements CustomerRating {
    @Override
    public void addCustomerRating(List<Customer> listCustomer, List<Lesson> listLesson,
                                  List<BookingOrder> bookingList, List<Rating> listRating) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please Enter Customer Name: ");
        String customerName = reader.readLine();

        System.out.println("Please Enter Customer Mobile Number: ");
        String customerMobileNumber = reader.readLine();

        Optional<Customer> customerFound = listCustomer.stream()
                .filter(x -> x.getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber))
                .findFirst();

        if (!customerFound.isPresent()) {
            System.out.println("Customer Not Found!!!");
        }

        customerFound = listCustomer.stream()
                .filter(x -> x.getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber))
                .findFirst();

        System.out.println("Please Enter Interested Fitness Class: " + java.util.Arrays.asList(LessonType.values()));
        String lessonName = reader.readLine();

        Optional<Lesson> lessonFound = listLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonName))
                .findFirst();
        if (!lessonFound.isPresent()){
            System.out.println("Lesson is not found. Please check lesson name properly.");
        }

        if (lessonFound.isPresent() && customerFound.isPresent()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Please enter lesson Date to set rating on that day (Ex: 10/03/2023):");
            String lessonDate = reader.readLine();
            if( lessonDate != null && !lessonDate.isEmpty() ) {
                List<Date> listLessonDates = lessonFound.get().getLessonDates();
                if(listLessonDates.contains(sdf.parse(lessonDate))){
                    System.out.println("Please add a rating on lesson: ");
                    System.out.println("1: Very dissatisfied \n 2: Dissatisfied \n 3: Ok \n 4: Satisfied\n 5: Very Satisfied\n");
                    String lessonRating = reader.readLine();
                    int intLessonRating = Integer.parseInt(lessonRating);
                    if( intLessonRating> 0 &&   intLessonRating<=5) {
                        System.out.println(" Lesson Found Add Customer Rating "+lessonFound.get().getLessonName());
                        System.out.println("Please add customer review: ");
                        String customerReview = reader.readLine();
                        Rating rating = new Rating(customerFound.get(), lessonFound.get().getLessonName(), intLessonRating, lessonDate,customerReview);
                        listRating.add(rating);
                        System.out.println("Rating for the user successfully added.");
                    } else {
                        System.out.println("Please enter  proper Rating as mentioned.");
                    }
                }
            }
        }
    }
}
