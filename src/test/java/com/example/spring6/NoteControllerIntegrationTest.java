package com.example.spring6;

import com.example.spring6.controller.NoteController;
import com.example.spring6.domain.Note;
import com.example.spring6.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class NoteControllerIntegrationTest {

    @MockBean
    public NoteService noteService;

    @Autowired
    public NoteController noteController;

    @Test
    void createNoteTest() {

        Note note = new Note();
        note.setId(1L);
        note.setHeading("Сон");
        note.setContent("Пора спать");
        given(noteService.createNote(note)).willReturn(note);
        ResponseEntity<Note> expectedNote = new ResponseEntity<>(note, HttpStatus.CREATED);

        ResponseEntity<Note> actualNote = noteController.createNote(note);

        assertEquals(actualNote, expectedNote);

    }
}
