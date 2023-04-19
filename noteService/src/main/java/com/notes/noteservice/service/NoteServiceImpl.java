package com.notes.noteservice.service;

import com.notes.noteservice.consumer.StudentConsumer;
import com.notes.noteservice.domain.Note;
import com.notes.noteservice.dto.NoteRequestDto;
import com.notes.noteservice.dto.NoteResponse;
import com.notes.noteservice.enums.Lessons;
import com.notes.noteservice.exception.ConflictException;
import com.notes.noteservice.repository.NoteRepository;
import model.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

    private final NoteRepository noteRepository;

    private StudentResponse studentResponse;

    private List<NoteResponse> noteResponses;

    public NoteServiceImpl(NoteRepository noteRepository) {

        this.noteRepository = noteRepository;
        this.noteResponses = new ArrayList<>();
    }

    public void setStudentResponse(StudentResponse studentResponse) {
        this.studentResponse = studentResponse;
    }



    public StudentResponse getStudentResponse() {
        return studentResponse;
    }

    @Override
    public Note createNote(Lessons lessons, NoteRequestDto noteRequestDto) {
        Note note = new Note();
        note.setPoint(noteRequestDto.getPoint());
       note.setStudentID(getStudentResponse().getSchoolNumber());
        note.setLessonName(lessons);
        if (noteRepository.existsByLessonName(note.getLessonName()) && (noteRequestDto.getStudentId() == getStudentResponse().getSchoolNumber() && noteRepository.existsByStudentID(getStudentResponse().getSchoolNumber()))) {
            logger.error(String.format("%s %s","This SchoolNumber and Lesson Point already saved with ID:",noteRequestDto.getStudentId()));
            throw new ConflictException("This SchoolNumber and Lesson Point already saved");
        }
        noteRepository.save(note);
        logger.info(String.format("%s %s","Student's note saved successfully with ID",note.getStudentID()));
        return note;
    }

    @Override
    public List<Note> notes() {
/*        noteRepository.findAll().stream().forEach(note -> {
            NoteResponse noteResponse =new NoteResponse();
            noteResponse.setStudentId(note.getStudentID());
            noteResponse.setLessons(note.getLessonName());
            noteResponse.setStudentName(getStudentResponse().getFirstName());
            noteResponses.add(noteResponse);
        });*/
        return noteRepository.findAll();
    }



}
