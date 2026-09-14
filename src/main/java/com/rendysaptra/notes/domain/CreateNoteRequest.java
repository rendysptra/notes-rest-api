package com.rendysaptra.notes.domain;

public record CreateNoteRequest(
    String title,
    String content,
    String url
) {
}
