package com.torik.assignment.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.torik.assignment.bean.Lesson;

public interface LessonBuilderDirector {

	public void addLessonsToList(List<Lesson> listOfLesson) throws IOException, ParseException;

	public void getAllLessons(List<Lesson> listOfLesson);
}
