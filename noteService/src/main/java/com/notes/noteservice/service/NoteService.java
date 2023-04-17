package com.notes.noteservice.service;

import com.notes.noteservice.domain.Note;
import com.notes.noteservice.dto.NoteRequestDto;
import com.notes.noteservice.dto.NoteResponse;
import com.notes.noteservice.enums.Lessons;
import model.StudentResponse;

import java.util.List;

public interface NoteService {

    Note createNote(Lessons lessons, NoteRequestDto noteRequestDto);

    List<Note> notes();

}
