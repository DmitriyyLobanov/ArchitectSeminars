package Seminar_8.MVP.presenters;

import Seminar_8.MVP.models.Table ;

import java.util.Collection;

public interface View {

    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    void printReservationTableResult(int reservationNo);

}
