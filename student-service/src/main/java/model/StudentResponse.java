package model;

import com.student.studentservice.enums.Gender;

import java.io.Serializable;

public class StudentResponse implements Serializable {


    private Integer schoolNumber;

    private String firstName;

    private String lastName;


    private Gender gender;

    public StudentResponse() {
    }

    public StudentResponse(Integer schoolNumber, String firstName, String lastName, Gender gender) {
        this.schoolNumber = schoolNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Integer getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(Integer schoolNumber) {
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
