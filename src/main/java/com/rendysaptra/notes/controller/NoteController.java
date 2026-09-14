package com.rendysaptra.notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.dto.CreateNoteRequestDto;
import com.rendysaptra.notes.domain.dto.NoteDto;
import com.rendysaptra.notes.domain.entity.Note;
import com.rendysaptra.notes.mapper.NoteMapper;
import com.rendysaptra.notes.service.NoteService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping(path = "/v1/notes")
public class NoteController {

    private final NoteService noteService;
    private final NoteMapper noteMapper;

    public NoteController(NoteService noteService, NoteMapper noteMapper){
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNote(
        @Valid @RequestBody CreateNoteRequestDto createNoteRequestDto
    ) {
        CreateNoteRequest createNoteRequest = noteMapper.fromDto(createNoteRequestDto);
        Note note = noteService.createNote(createNoteRequest);
        NoteDto createdNoteDto = noteMapper.toDto(note);
        return new ResponseEntity<NoteDto>(createdNoteDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> listNotes(){
        List<Note> notes = noteService.listNotes();
        List<NoteDto> noteDtos = notes.stream().map(noteMapper::toDto).toList();
        return ResponseEntity.ok(noteDtos);
    }

}
