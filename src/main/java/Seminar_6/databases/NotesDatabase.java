package Seminar_6.databases;

import Seminar_6.notes.infrastructure.Database ;

public class NotesDatabase implements Database {

    private NotesTable notesTable = new NotesTable();

    public NotesTable getNotesTable() {
        return notesTable;
    }
}
