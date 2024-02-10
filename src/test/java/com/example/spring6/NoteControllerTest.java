package com.example.spring6;

import com.example.spring6.controller.NoteController;
import com.example.spring6.domain.Note;
import com.example.spring6.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class NoteControllerTest {

    @Mock
    public NoteService noteService;

    @InjectMocks
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
