package com.rendysaptra.notes.mapper.impl;

import org.springframework.stereotype.Component;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.dto.CreateNoteRequestDto;
import com.rendysaptra.notes.domain.dto.NoteDto;
import com.rendysaptra.notes.domain.entity.Note;
import com.rendysaptra.notes.mapper.NoteMapper;

@Component 
public class NoteMapperImpl implements NoteMapper{

    @Override
    public CreateNoteRequest fromDto(CreateNoteRequestDto dto) {
        return new CreateNoteRequest(
            dto.title(),
            dto.content(),
            dto.url()
        );
    }

    @Override
    public NoteDto toDto(Note note) {
        return new NoteDto(
            note.getId(),
            note.getTitle(),
            note.getContent(),
            note.getUrl(),
            note.getCreated(),
            note.getUpdated()
        );
    }

}
