package Seminar_8.MVP.presenters;

import Seminar_8.MVP.models.Reservation;
import Seminar_8.MVP.models.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получить список всех столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    protected void printReservationTableResult(int reservationNo, String name){
        view.printReservationTableResult(reservationNo, name);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(reservationDate, tableNo, name);
        printReservationTableResult(reservationNo, name);
    }

    public void onChangeReservationTable(int oldReservationId, Date reservationDate, int tableNo, String name){
        tables = model.loadTables();
        for (Table table: tables) {
            Collection<Reservation> tempReservationsList = new ArrayList<>(table.getReservations());
            for (Reservation reservation: tempReservationsList) {
                if(reservation.getId() == oldReservationId){
                    int reservationNo = model.reservationTable(new Date(), tableNo, name);
                    printReservationTableResult(reservationNo, name);
                }
            }
        }
    }
}
