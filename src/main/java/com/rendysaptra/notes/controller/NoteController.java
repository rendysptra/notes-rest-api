package com.rendysaptra.notes.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.UpdateNoteRequest;
import com.rendysaptra.notes.domain.dto.CreateNoteRequestDto;
import com.rendysaptra.notes.domain.dto.NoteDto;
import com.rendysaptra.notes.domain.dto.UpdateNoteRequestDto;
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

    @PutMapping("/{noteId}")
    public ResponseEntity<NoteDto> updateNote(
        @PathVariable UUID noteId,
        @Valid @RequestBody UpdateNoteRequestDto updateNoteRequestDto
    ) {
        UpdateNoteRequest updateNoteRequest = noteMapper.fromDto(updateNoteRequestDto);
        Note note = noteService.updateNote(noteId, updateNoteRequest);
        NoteDto updatedNoteDto = noteMapper.toDto(note);

        return ResponseEntity.ok(updatedNoteDto);
    }

    @DeleteMapping(path = "/{noteId}") 
    public ResponseEntity<Void> deleteNote(
        @PathVariable UUID noteId
    ){
        noteService.deleteNote(noteId);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
