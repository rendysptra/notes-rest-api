package com.rendysaptra.notes.service.impl;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.entity.Note;
import com.rendysaptra.notes.repository.NoteRepository;
import com.rendysaptra.notes.service.NoteService;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service 
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNote(CreateNoteRequest request) {
        Instant now = Instant.now();

        Note note = new Note(
            null,
            request.title(),
            request.content(),
            request.url(),
            now,
            now
        );
        return noteRepository.save(note);
    }

    @Override
    public List<Note> listNotes() {
        return noteRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

}
