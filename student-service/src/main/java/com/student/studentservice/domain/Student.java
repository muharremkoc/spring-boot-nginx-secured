package com.student.studentservice.domain;

import com.student.studentservice.enums.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(generator = "my_entity_seq")
    @GenericGenerator(name = "my_entity_seq", strategy = "com.student.studentservice.generator.IDGenerator")
    int schoolNumber;

    String firstName;

    String lastName;

    @Enumerated(EnumType.STRING)
    Gender gender;

    public Student() {
    }

    public Student(int schoolNumber, String firstName, String lastName, Gender gender) {
        this.schoolNumber = schoolNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
