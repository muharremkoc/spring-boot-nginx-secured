package com.notes.noteservice.dto;

public class NoteRequestDto {

    private int studentId;

    private int point;

    public NoteRequestDto(int studentId, int point) {
        this.studentId = studentId;
        this.point = point;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
