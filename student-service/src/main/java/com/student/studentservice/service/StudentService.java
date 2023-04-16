package com.student.studentservice.service;

import com.student.studentservice.domain.Student;
import com.student.studentservice.dto.StudentRequestDto;
import com.student.studentservice.enums.Gender;
import model.StudentResponse;

public interface StudentService {

    Student createStudent(StudentRequestDto studentRequestDto, Gender gender);

    StudentResponse getStudent(int schoolNumber);

}
