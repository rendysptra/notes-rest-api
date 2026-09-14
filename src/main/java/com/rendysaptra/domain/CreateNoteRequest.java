package com.rendysaptra.domain;

public record CreateNoteRequest(
    String title,
    String content,
    String url
) {
}
