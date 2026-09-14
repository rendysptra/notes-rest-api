package com.rendysaptra.service.impl;

import com.rendysaptra.repository.NoteRepository;
import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rendysaptra.domain.CreateNoteRequest;
import com.rendysaptra.domain.entity.Note;
import com.rendysaptra.service.NoteService;

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
