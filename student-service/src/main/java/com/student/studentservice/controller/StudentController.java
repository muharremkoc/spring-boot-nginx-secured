package com.student.studentservice.controller;

import com.student.studentservice.domain.Student;
import com.student.studentservice.dto.StudentRequestDto;
import com.student.studentservice.enums.Gender;
import com.student.studentservice.service.StudentService;
import model.StudentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/versions/1/student")
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public Student createStudent(@RequestBody StudentRequestDto studentRequestDto, @RequestParam Gender gender){
        return studentService.createStudent(studentRequestDto, gender);
    }
    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }
}
