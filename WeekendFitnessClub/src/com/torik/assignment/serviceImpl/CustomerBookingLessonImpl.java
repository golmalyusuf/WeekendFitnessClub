package com.torik.assignment.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.torik.assignment.bean.BookingOrder;
import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.service.CustomerBookingLesson;
import com.torik.assignment.service.RegisterCustomer;

public class CustomerBookingLessonImpl implements CustomerBookingLesson {

    @Override
    public void customerBookALesson(List<Customer> listCustomer, List<Lesson> listLesson,
                                    List<BookingOrder> bookingList) throws IOException {
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
            RegisterCustomer registerCustomer = new RegisterCustomerImpl();
            registerCustomer.addCustomerToListWithName(listCustomer, customerName, customerMobileNumber);
        }

        customerFound = listCustomer.stream()
                .filter(x -> x.getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber))
                .findFirst();

        System.out.println("Please Enter Interested Fitness Class: " + java.util.Arrays.asList(LessonType.values()));
        String lessonName = reader.readLine();

        Optional<Lesson> lessonFound = listLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonName))
                .findFirst();


        if (lessonFound.isPresent() && customerFound.isPresent()) {
            BookingOrder bookingOrder = new BookingOrder();

            Optional<BookingOrder> bookingOrderForCustomer = bookingList.stream()
                    .filter(x -> x.getCustomer().getCustomerName().equalsIgnoreCase(customerName)
                            && x.getCustomer().getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber))
                    .findFirst();

            if (bookingOrderForCustomer.isPresent()) {
                Optional<Lesson> lessonForCustomer = bookingOrderForCustomer.get().getListLesson().stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonName)).findFirst();
                if (lessonForCustomer.isPresent()) {
                    System.out.println(customerName + " Customer already enrolled in the course!!!");
                } else {
                    bookingOrder.setCustomer(customerFound.get());
                    List<Lesson> newLessonList = bookingOrderForCustomer.get().getListLesson();
                    newLessonList.add(lessonFound.get());
                    bookingOrder.setListLesson(newLessonList);
                    Map<String, String> map = bookingOrderForCustomer.get().getStatusMap();
                    map.put(lessonFound.get().getLessonName(), "Booked");

                    bookingOrder.setStatusMap(map);
                    lessonFound.get().setNumOfCustomer(lessonFound.get().getNumOfCustomer() + 1);
                    System.out.println(customerName + " Customer enrolled successfully!!!");
                }
            } else {
                bookingOrder.setCustomer(customerFound.get());
                List<Lesson> newLessonList = new ArrayList<Lesson>();
                newLessonList.add(lessonFound.get());
                bookingOrder.setListLesson(newLessonList);
                Map<String, String> map = new HashMap<>();
                map.put(lessonFound.get().getLessonName(), "Booked");

                bookingOrder.setStatusMap(map);
                bookingList.add(bookingOrder);
                lessonFound.get().setNumOfCustomer(lessonFound.get().getNumOfCustomer() + 1);

                System.out.println(customerName + " Customer enrolled successfully!!!");
            }

        } else {
            System.out.println("Please enter proper lesson name!!!");
        }
    }

    @Override
    public void customerCancelBookBooking(List<Customer> listCustomer, List<Lesson> listLesson,
                                          List<BookingOrder> bookingList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Customer Name: ");
        String customerName = reader.readLine();

        System.out.println("Please Enter Customer Mobile Number: ");
        String customerMobileNumber = reader.readLine();

        Optional<BookingOrder> customerBookingOrder = bookingList.stream()
                .filter(x -> x.getCustomer().getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCustomer().getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber)).findFirst();


        if (!customerBookingOrder.isPresent()) {
            System.out.println("Please enter valid customer!!!!");
            return;
        }

        System.out.println("Please Enter The Fitness Class Name Customer Wants to Cancel: " + java.util.Arrays.asList(LessonType.values()));
        String lessonName = reader.readLine();

        Optional<Lesson> lessonFound = listLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonName))
                .findFirst();
        if (lessonFound.isPresent() && customerBookingOrder.isPresent()) {
            customerBookingOrder.get().getListLesson().remove(lessonFound.get());
            lessonFound.get().setNumOfCustomer(lessonFound.get().getNumOfCustomer() - 1);
            System.out.println("Course Cancelled");
        }
    }

    @Override
    public void customerChangeBookBooking(List<Customer> listCustomer, List<Lesson> listLesson,
                                          List<BookingOrder> bookingList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Customer Name: ");
        String customerName = reader.readLine();

        System.out.println("Please Enter Customer Mobile Number: ");
        String customerMobileNumber = reader.readLine();

        Optional<BookingOrder> customerBookingOrder = bookingList.stream()
                .filter(x -> x.getCustomer().getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCustomer().getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber)).findFirst();


        if (!customerBookingOrder.isPresent()) {
            System.out.println("Please enter valid customer!!!!");
            return;
        }

        System.out.println("Please Enter The Fitness Class Name Customer Wants to Change: " + java.util.Arrays.asList(LessonType.values()));
        String lessonNameToChange = reader.readLine();

        System.out.println("Please Enter The Fitness Class Name Customer Wants to Change With: " + java.util.Arrays.asList(LessonType.values()));
        String lessonNameToChangeWith = reader.readLine();
        Optional<Lesson> lessonFoundToChange = listLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonNameToChange))
                .findFirst();

        Optional<Lesson> lessonFoundToChangeWith = listLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonNameToChangeWith))
                .findFirst();

        if (lessonFoundToChange.isPresent() && lessonFoundToChangeWith.isPresent()) {
            if (lessonFoundToChangeWith.get().getNumOfCustomer() < 5) {
                List<Lesson> list = customerBookingOrder.get().getListLesson();
                list.remove(lessonFoundToChange.get());
                list.add(lessonFoundToChangeWith.get());
                customerBookingOrder.get().setListLesson(list);
                lessonFoundToChange.get().setNumOfCustomer(lessonFoundToChange.get().getNumOfCustomer() - 1);
                lessonFoundToChangeWith.get().setNumOfCustomer(lessonFoundToChangeWith.get().getNumOfCustomer() + 1);
            }

        }

    }

    @Override
    public void showAllBooking(List<BookingOrder> bookingList) throws IOException {
        System.out.println("Printing all the Bookings for all Customers.");
        AtomicInteger countLessons = new AtomicInteger(1);
        bookingList.stream().forEach(x -> {
            System.out.println(countLessons.getAndIncrement() + "		" + x.getCustomer().getCustomerName() + "  " + x.getCustomer().getCusotmerMobileNo());
            x.getListLesson().stream().forEach(lesson -> System.out.println("				" + lesson.getLessonName() + "  " + x.getStatusMap().get(lesson.getLessonName())));
        });
    }

    @Override
    public void setCustomerAttendanceModification(List<Customer> customerList, List<Lesson> listOfLesson, List<BookingOrder> listOfBooking) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Customer Name: ");
        String customerName = reader.readLine();

        System.out.println("Please Enter Customer Mobile Number: ");
        String customerMobileNumber = reader.readLine();

        Optional<BookingOrder> customerBookingOrder = listOfBooking.stream()
                .filter(x -> x.getCustomer().getCustomerName().equalsIgnoreCase(customerName)
                        && x.getCustomer().getCusotmerMobileNo().equalsIgnoreCase(customerMobileNumber)).findFirst();


        if (!customerBookingOrder.isPresent()) {
            System.out.println("Please enter valid customer!!!!");
            return;
        }

        System.out.println("Please Enter The Fitness Class Name for Customer to modify attendance: " + java.util.Arrays.asList(LessonType.values()));
        String lessonNameToUpdateAttendanceStatus = reader.readLine();
        Optional<Lesson> lessonFoundToChange = listOfLesson.stream().filter(x -> x.getLessonName().equalsIgnoreCase(lessonNameToUpdateAttendanceStatus))
                .findFirst();
        if (lessonFoundToChange.isPresent()) {

            List<Lesson> list = customerBookingOrder.get().getListLesson();
            list.forEach(x -> System.out.println(x.getLessonName()));


            System.out.println("Please update customer attendance status: (Booked, Attended, Cancelled, Changed)");
            String customerAttendanceLessonStatus = reader.readLine();
            Map map = customerBookingOrder.get().getStatusMap();

            map.put(lessonNameToUpdateAttendanceStatus, customerAttendanceLessonStatus);
            customerBookingOrder.get().setStatusMap(map);
            System.out.println("Customer's attendance status update successful");
        } else{
            System.out.println("Lesson not found for the Customer "+lessonNameToUpdateAttendanceStatus );
        }

    }
}
