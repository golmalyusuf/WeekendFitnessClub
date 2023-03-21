package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.CustomerRatingOnLesson;
import com.torik.assignment.service.RegisterCustomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class CustomerRatingOnLessonImpl implements CustomerRatingOnLesson {
    @Override
    public void customerEntersLessonRating(List<Customer> customerList, List<Lesson> lessonList, List<Rating> listOfRating) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Customer Name: ");
        String customerName = reader.readLine();

        System.out.println("Please Enter Customer Mobile Number: ");
        String customerMobileNumber = reader.readLine();

        Optional<Customer> customerFound = customerList.stream()
                .filter(x -> x.getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber))
                .findFirst();

        if (!customerFound.isPresent()) {
            System.out.println("Customer is not registered!!!");
            return;
        }

        System.out.println("Please Enter Interested Fitness Class: " + java.util.Arrays.asList(LessonType.values()));
        String lessonName = reader.readLine();
        Optional<Lesson> lessonFound = lessonList.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonName))
                .findFirst();


        if (lessonFound.isPresent() && customerFound.isPresent()) {
            System.out.println("Please Enter Customer Rating 1 to 5:" );
            int customerRating = Integer.parseInt(reader.readLine());
            Rating rating = new Rating();
            rating.setCustoemr(customerFound.get());
            rating.setLesson(lessonFound.get());
            rating.setRating(customerRating);
            listOfRating.add(rating);
        }

    }
}
