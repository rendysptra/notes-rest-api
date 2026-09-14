package com.rendysaptra.domain.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record CreateNoteRequestDto(
    
    @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
    String title,

    @Nullable
    String content,

    @Nullable 
    String url
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH = 
        "Title must be between 1 and 255 characters";
}
