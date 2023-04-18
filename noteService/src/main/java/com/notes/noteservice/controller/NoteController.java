package com.notes.noteservice.controller;

import com.notes.noteservice.domain.Note;
import com.notes.noteservice.dto.NoteRequestDto;
import com.notes.noteservice.dto.NoteResponse;
import com.notes.noteservice.enums.Lessons;
import com.notes.noteservice.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/create")
    public Note createNote(@RequestParam Lessons lessons, @RequestBody NoteRequestDto noteRequestDto){
        return noteService.createNote(lessons, noteRequestDto);
    }
    @GetMapping("/list")
    public List<Note> getNotes(){
        return noteService.notes();
    }
}
