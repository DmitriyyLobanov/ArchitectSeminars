package Seminar_6;

import Seminar_6.databases.NotesDatabase ;
import Seminar_6.notes.core.application.ConcreteNoteEditor ;
import Seminar_6.notes.infrastructure.DatabaseContext ;
import Seminar_6.notes.presentation.queries.controllers.NotesController ;
import Seminar_6.notes.presentation.queries.views.NotesConsolePresenter ;

public class Sample01 {

    /**
     * Приложение "редактор заметок"
     *      *     * TODO: ДОМАШНЯЯ РАБОТА
     *      *      *  разработать UML-диаграмму классов для текущего приложения
     */
    public static void main(String[] args) {
        NotesController notesController = new NotesController(
                new ConcreteNoteEditor(new DatabaseContext(new NotesDatabase()), new NotesConsolePresenter()));
        notesController.routeGetAll();
    }

}
