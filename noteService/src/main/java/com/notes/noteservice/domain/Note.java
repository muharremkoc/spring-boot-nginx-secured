package com.notes.noteservice.domain;

import com.notes.noteservice.enums.Lessons;
import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Lessons lessonName;

    private int point;
    private int studentID;

    public Note() {
    }

    public Note(int id, Lessons lessonName,int point,int studentID) {
        this.id = id;
        this.lessonName = lessonName;
        this.studentID = studentID;
        this.point = point;
    }

    public Note(Lessons lessonName,int point,int studentID) {
        this.lessonName = lessonName;
        this.studentID = studentID;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lessons getLessonName() {
        return lessonName;
    }

    public void setLessonName(Lessons lessonName) {
        this.lessonName = lessonName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
