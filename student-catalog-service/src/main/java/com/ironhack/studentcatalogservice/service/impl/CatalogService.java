package com.ironhack.studentcatalogservice.service.impl;


import com.ironhack.studentcatalogservice.client.GradesDataService;
import com.ironhack.studentcatalogservice.client.StudentInfoService;
import com.ironhack.studentcatalogservice.model.*;
import com.ironhack.studentcatalogservice.service.interfaces.CatalogServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CatalogService implements CatalogServiceInterface {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private GradesDataService gradesDataService;

    public Catalog getCatalog(String courseCode) {

//        You need to create some of the methods used here in the client package for it to work

        Course course = gradesDataService.getCourseByCourseCode(courseCode);
        CourseGrade courseGrades = gradesDataService.getCourseGrades(courseCode);
        Catalog catalog = new Catalog();
        catalog.setCourseName(course.getCourseName());
        List<StudentGrade> studentGrades = new ArrayList<>();

        for (Grade grade : courseGrades.getGrades()) {
            Student student = studentInfoService.getStudentInfo(grade.getStudentId());
            studentGrades.add(new StudentGrade(student.getName(), student.getAge(), grade.getGrade()));
        }

        catalog.setStudentGrades(studentGrades);
        return catalog;
    }
}
