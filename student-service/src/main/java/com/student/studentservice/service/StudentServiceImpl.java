package com.student.studentservice.service;

import com.student.studentservice.domain.Student;
import com.student.studentservice.dto.StudentRequestDto;
import com.student.studentservice.enums.Gender;
import com.student.studentservice.producer.KafkaProducer;
import com.student.studentservice.repository.StudentRepository;
import model.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final KafkaProducer kafkaProducer;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(KafkaProducer kafkaProducer, StudentRepository studentRepository) {
        this.kafkaProducer = kafkaProducer;
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentRequestDto studentRequestDto, Gender gender) {
        Student student = new Student(studentRequestDto.getFirstName(),studentRequestDto.getLastName(),gender);
        studentRepository.save(student);
        logger.info(String.format("%s %s","Student saved success with SchoolNumber:",student.getSchoolNumber()));
        return student;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponse sendStudent(int schoolNumber) {
        Student student = studentRepository.findBySchoolNumber(schoolNumber);
        if (student == null){
            logger.error(String.format("%s %s","Student not found with SchoolNumber:",schoolNumber));
            throw new RuntimeException("Student not found with SchoolNumber:" + schoolNumber);
        }
        StudentResponse studentResponse = new StudentResponse(student.getSchoolNumber(),student.getFirstName(),student.getLastName(),student.getGender());
        kafkaProducer.studentProducer(studentResponse);
        return studentResponse;
    }

}
