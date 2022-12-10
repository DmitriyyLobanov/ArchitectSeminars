package Seminar_6.notes.core.application.interfaces;

import Seminar_6.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

}
