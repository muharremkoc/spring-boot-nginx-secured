package com.notes.noteservice.service;

import com.notes.noteservice.consumer.StudentConsumer;
import com.notes.noteservice.domain.Note;
import com.notes.noteservice.dto.NoteRequestDto;
import com.notes.noteservice.dto.NoteResponse;
import com.notes.noteservice.enums.Lessons;
import com.notes.noteservice.repository.NoteRepository;
import model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    public void setStudentResponse(StudentResponse studentResponse) {
        this.studentResponse = studentResponse;
    }

    private StudentResponse studentResponse;

    private List<NoteResponse> noteResponses= new ArrayList<>();

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;

    }

    @Override
    public Note createNote(Lessons lessons, NoteRequestDto noteRequestDto) {
        Note note = new Note();
        note.setPoint(noteRequestDto.getPoint());
       note.setStudentID(studentResponse.getSchoolNumber());
        note.setLessonName(lessons);
        return noteRepository.save(note);
    }

    @Override
    public List<NoteResponse> notes() {
        NoteResponse noteResponse =new NoteResponse();
        noteRepository.findAll().stream().forEach(note -> {
            noteResponse.setStudentId(note.getStudentID());
            noteResponse.setLessons(note.getLessonName());
            noteResponse.setStudentName(studentResponse.getFirstName());
            noteResponses.add(noteResponse);
        });
        return noteResponses;
    }



}
