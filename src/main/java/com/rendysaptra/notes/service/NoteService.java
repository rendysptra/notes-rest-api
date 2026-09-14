package com.rendysaptra.notes.service;

import java.util.List;
import java.util.UUID;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.UpdateNoteRequest;
import com.rendysaptra.notes.domain.entity.Note;

public interface NoteService {

    Note createNote(CreateNoteRequest request);

    Note updateNote(UUID id, UpdateNoteRequest request);

    List<Note> listNotes();

    void deleteNote(UUID noteId);

}
