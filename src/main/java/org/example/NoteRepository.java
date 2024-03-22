package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Method to update a note
    Note saveAndFlush(Note note);
    void deleteById(Long id);
}
