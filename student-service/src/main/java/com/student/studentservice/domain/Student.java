package com.student.studentservice.domain;

import com.student.studentservice.enums.Gender;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(generator = "my_entity_seq")
    @GenericGenerator(name = "my_entity_seq", strategy = "com.student.studentservice.generator.IDGenerator")
    int id;

    String firstName;

    String lastName;

    @Enumerated(EnumType.STRING)
    Gender gender;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, Gender gender) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
