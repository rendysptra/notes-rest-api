package com.rendysaptra.notes.mapper;

import com.rendysaptra.notes.domain.CreateNoteRequest;
import com.rendysaptra.notes.domain.UpdateNoteRequest;
import com.rendysaptra.notes.domain.dto.CreateNoteRequestDto;
import com.rendysaptra.notes.domain.dto.NoteDto;
import com.rendysaptra.notes.domain.dto.UpdateNoteRequestDto;
import com.rendysaptra.notes.domain.entity.Note;

public interface NoteMapper {

    CreateNoteRequest fromDto(CreateNoteRequestDto dto);

    UpdateNoteRequest fromDto(UpdateNoteRequestDto dto);

    NoteDto toDto(Note note);

}
