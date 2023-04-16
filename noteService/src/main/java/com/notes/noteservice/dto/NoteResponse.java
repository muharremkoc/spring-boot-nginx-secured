package com.notes.noteservice.dto;

import com.notes.noteservice.enums.Lessons;

public class NoteResponse {

       int studentId;

       String studentName;

       Lessons lessons;

       public NoteResponse() {
       }

       public NoteResponse(int studentId, String studentName, Lessons lessons) {
              this.studentId = studentId;
              this.studentName = studentName;
              this.lessons = lessons;
       }

       public int getStudentId() {
              return studentId;
       }

       public void setStudentId(int studentId) {
              this.studentId = studentId;
       }

       public String getStudentName() {
              return studentName;
       }

       public void setStudentName(String studentName) {
              this.studentName = studentName;
       }

       public Lessons getLessons() {
              return lessons;
       }

       public void setLessons(Lessons lessons) {
              this.lessons = lessons;
       }
}
