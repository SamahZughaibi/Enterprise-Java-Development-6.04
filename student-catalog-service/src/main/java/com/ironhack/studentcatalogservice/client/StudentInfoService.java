package com.ironhack.studentcatalogservice.client;

import com.ironhack.studentcatalogservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("student-info-service")
public interface StudentInfoService {
    @GetMapping("/students/{studentId}")
    Student getStudentInfo(@PathVariable String studentId);
}
