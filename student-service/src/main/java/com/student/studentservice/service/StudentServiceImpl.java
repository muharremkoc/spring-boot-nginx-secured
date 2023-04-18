package com.student.studentservice.service;

import com.student.studentservice.domain.Student;
import com.student.studentservice.dto.StudentRequestDto;
import com.student.studentservice.enums.Gender;
import com.student.studentservice.producer.KafkaProducer;
import com.student.studentservice.repository.StudentRepository;
import model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final KafkaProducer kafkaProducer;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(KafkaProducer kafkaProducer, StudentRepository studentRepository) {
        this.kafkaProducer = kafkaProducer;
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentRequestDto studentRequestDto, Gender gender) {
        Student student = new Student(studentRequestDto.getFirstName(),studentRequestDto.getLastName(),gender);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponse sendStudent(int schoolNumber) {
        Student student = studentRepository.findBySchoolNumber(schoolNumber);
        if (student == null) throw new RuntimeException("Student not found with SchoolNumber:" + schoolNumber);
        StudentResponse studentResponse = new StudentResponse(student.getSchoolNumber(),student.getFirstName(),student.getLastName(),student.getGender());
        kafkaProducer.studentProducer(studentResponse);
        return studentResponse;
    }

}
