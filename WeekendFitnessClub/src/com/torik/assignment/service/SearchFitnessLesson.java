package com.torik.assignment.service;

import com.torik.assignment.bean.Lesson;

import java.io.IOException;
import java.util.List;

public interface SearchFitnessLesson {
    public void findFitnessLessonByName(List<Lesson> lessonList) throws IOException;
    public void findFitnessLessonByWeekendName(List<Lesson> lessonList) throws IOException;
}
