package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.Lesson;
import com.torik.assignment.service.LessonBuilderDirector;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LessonBuilderDirectorImplTest {

    @Test
    public void testAddLessonsToList() throws IOException, ParseException {
        String input = "YOGA\n08/04/2023\n09/04/2023\n0\n200\n"; // example input with name and mobile number
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<Lesson> listOfLesson = new ArrayList<Lesson>();
        LessonBuilderDirector createLesson = new LessonBuilderDirectorImpl();
        createLesson.addLessonsToList(listOfLesson);

        int resultSize =    listOfLesson.stream().filter(x-> x.getLessonName().equalsIgnoreCase("YOGA")).collect(Collectors.toList()).size();
        assertEquals(1, resultSize);
    }

}