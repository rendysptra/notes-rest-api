package com.rendysaptra.service;

import java.util.List;

import com.rendysaptra.domain.CreateNoteRequest;
import com.rendysaptra.domain.entity.Note;

public interface NoteService {

    Note createNote(CreateNoteRequest request);

    List<Note> listNotes();

}
