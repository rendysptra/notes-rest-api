package com.rendysaptra.mapper;

import com.rendysaptra.domain.CreateNoteRequest;
import com.rendysaptra.domain.dto.CreateNoteRequestDto;
import com.rendysaptra.domain.dto.NoteDto;
import com.rendysaptra.domain.entity.Note;

public interface NoteMapper {

    CreateNoteRequest fromDto(CreateNoteRequestDto dto);

    NoteDto toDto(Note note);

}
