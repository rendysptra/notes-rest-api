package com.rendysaptra.domain.dto;

import java.time.Instant;
import java.util.UUID;

public record NoteDto(
    UUID id,
    String title,
    String content,
    String url,
    Instant created,
    Instant updated
) {
}
