package com.rendysaptra.mapper.impl;

import org.springframework.stereotype.Component;

import com.rendysaptra.domain.CreateNoteRequest;
import com.rendysaptra.domain.dto.CreateNoteRequestDto;
import com.rendysaptra.domain.dto.NoteDto;
import com.rendysaptra.domain.entity.Note;
import com.rendysaptra.mapper.NoteMapper;

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
