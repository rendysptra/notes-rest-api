package com.rendysaptra.notes.domain;

public record UpdateNoteRequest(
    String title,
    String content,
    String url
) {

}
