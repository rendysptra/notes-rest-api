package com.rendysaptra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rendysaptra.domain.entity.Note;

@Repository 
public interface NoteRepository extends JpaRepository<Note, UUID>{

}
