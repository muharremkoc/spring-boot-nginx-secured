package com.student.studentservice.controller;

import com.student.studentservice.domain.Student;
import com.student.studentservice.dto.StudentRequestDto;
import com.student.studentservice.enums.Gender;
import com.student.studentservice.service.StudentService;
import model.StudentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentRequestDto studentRequestDto, @RequestParam Gender gender){
        return studentService.createStudent(studentRequestDto, gender);
    }
    @PostMapping("/sendProducer/{schoolNumber}")
    public StudentResponse sendStudent(@PathVariable("schoolNumber") int schoolNumber){
        return studentService.sendStudent(schoolNumber);
    }

    @GetMapping("/list")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
