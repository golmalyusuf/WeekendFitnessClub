package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;
import com.torik.assignment.service.LessonReports;

import java.util.List;

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
            System.out.println("Lesson Name: " + lesson.getLessonName() + "  " +avgValue);
        });
    }
}
