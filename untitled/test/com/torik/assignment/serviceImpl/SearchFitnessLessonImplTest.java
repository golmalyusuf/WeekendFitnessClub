package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.Lesson;
import org.junit.Test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SearchFitnessLessonImplTest {
    List<Lesson> listOfLesson = new ArrayList<Lesson>();
    private  void setLessonsForTest(List<Lesson> listOfLesson) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "25/03/2023";
        String dateInString2 = "26/03/2023";
        Date date = formatter.parse(dateInString);
        Date date2 = formatter.parse(dateInString2);

        Lesson l1 = new Lesson();
        l1.setCapacityOfClass(5);
        Date[] dateArr = {date, date2};

        l1.setLessionDates(Arrays.asList(dateArr) );
        l1.setPrice(100);
        l1.setLessonName("SPIN");
        l1.setMaxWeeklysession(4);
        l1.setNumOfCustomer(0);

        Lesson l2 = new Lesson();
        l2.setCapacityOfClass(5);
        l2.setLessionDates(Arrays.asList(dateArr) );
        l2.setPrice(100);
        l2.setLessonName("Yoga");
        l2.setMaxWeeklysession(4);
        l2.setNumOfCustomer(0);
        listOfLesson.add(l1);
        listOfLesson.add(l2);
    }
    @Test
    public void findFitnessLessonByName() throws Exception {
        setLessonsForTest(listOfLesson);
        int resultSize =    listOfLesson.stream().filter(x-> x.getLessonName().equalsIgnoreCase("YOGA")).collect(Collectors.toList()).size();
        assertTrue("Lesson list size (" + resultSize + ") should be greater than or equal 1 ", resultSize >= 1);
    }

    @Test
    public void findFitnessLessonByWeekendName() {
        String weekendName = "Saturday";
        Format f = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //listOfLesson.stream().forEach(al -> al.getLessonDates().stream().filter(date -> f.format(date).equalsIgnoreCase(weekendName)).collect(Collectors.toList()).size())
        //listOfLesson.stream().forEach(x-> x.getLessonDates().stream().filter(date-> f.format(date).equalsIgnoreCase(weekendName)).collect(Collectors.toList())).
        long count = listOfLesson.stream()
                .flatMap(lesson -> lesson.getLessonDates().stream()) // flattening the list of Person objects
                .map( Lesson ::getLessonDates) // extracting the name of each Person object
                .filter(name -> name.equals(weekendName)) // filtering for the target name
                .count();
        assertEquals(1, resultSize);
    }
}