package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.Lesson;
import com.torik.assignment.service.SearchFitnessLesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class SearchFitnessLessonImpl implements SearchFitnessLesson {
    @Override
    public void findFitnessLessonByName(List<Lesson> lessonList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Lesson Name to see the time table: ");
        String lessonName = reader.readLine();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        lessonList.stream().filter(l -> l.getLessonName().equalsIgnoreCase(lessonName)).forEach(x -> x.getLessonDates().stream().forEach(y -> System.out.println(dateFormat.format(y))));
    }

    @Override
    public void findFitnessLessonByWeekendName(List<Lesson> lessonList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Weekend Name to see the time table on the day: (Saturday or Sunday) ");
        String lessonName = reader.readLine();
        Format f = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // lessonList.stream().filter(l-> l.getLessonDates().stream().filter(d->
        //         f.format(d).equalsIgnoreCase("Saturday") || f.format(d).equalsIgnoreCase("Sunday")).forEach(x-> System.out.println(sdf.format(x)))).count();

        lessonList.stream().forEach(al -> al.getLessonDates().stream().filter(date -> f.format(date).equalsIgnoreCase("Sunday") || f.format(date).equalsIgnoreCase("Saturday")).forEach(m-> System.out.println(al.getLessonName()+"    "+sdf.format(m))));
    }
}
