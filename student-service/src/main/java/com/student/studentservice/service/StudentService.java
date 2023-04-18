package com.student.studentservice.service;

import com.student.studentservice.domain.Student;
import com.student.studentservice.dto.StudentRequestDto;
import com.student.studentservice.enums.Gender;
import model.StudentResponse;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentRequestDto studentRequestDto, Gender gender);

    List<Student> getStudents();

    StudentResponse sendStudent(int schoolNumber);

}
