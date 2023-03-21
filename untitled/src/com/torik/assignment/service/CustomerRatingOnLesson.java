package com.torik.assignment.service;

import com.torik.assignment.bean.Customer;
import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;

import java.io.IOException;
import java.util.List;

public interface CustomerRatingOnLesson {
    public void customerEntersLessonRating(List<Customer> customerList, List<Lesson> lessonList, List<Rating> listOfRating) throws IOException;
}
