package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }

    public Note createOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNoteById(Long id, Note newNoteData) {
        Note existingNote = getNoteById(id);
        existingNote.setTitle(newNoteData.getTitle());
        existingNote.setContent(newNoteData.getContent());
        return noteRepository.save(existingNote);
    }
}
