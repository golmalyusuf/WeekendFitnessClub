package com.torik.assignment.service;

import com.torik.assignment.bean.Lesson;
import com.torik.assignment.bean.Rating;

import java.util.List;

public interface LessonReports {
    public void generateLessonReportWithRating(List<Lesson> listLesson, List<Rating> listRating);
}