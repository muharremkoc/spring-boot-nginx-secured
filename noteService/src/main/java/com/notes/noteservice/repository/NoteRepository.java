package com.notes.noteservice.repository;

import com.notes.noteservice.domain.Note;
import com.notes.noteservice.enums.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Integer> {

    Note findById(int id);

    Note findByLessonName(Lessons lessons);
}
