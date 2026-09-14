package com.rendysaptra.notes.service;

import java.util.List;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.entity.Note;

public interface NoteService {

    Note createNote(CreateNoteRequest request);

    List<Note> listNotes();

}
