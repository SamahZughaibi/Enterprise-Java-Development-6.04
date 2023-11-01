package com.ironhack.studentcatalogservice.client;

import com.ironhack.studentcatalogservice.model.Course;
import com.ironhack.studentcatalogservice.model.CourseGrade;
import com.ironhack.studentcatalogservice.model.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient("grades-data-service")
public interface GradesDataService {
    @GetMapping("/courses/{courseCode}")
    Course getCourseByCourseCode(@PathVariable String courseCode);
    @GetMapping("/courses/{courseCode}/grades")
    CourseGrade getCourseGrades(@PathVariable String courseCode);

}
