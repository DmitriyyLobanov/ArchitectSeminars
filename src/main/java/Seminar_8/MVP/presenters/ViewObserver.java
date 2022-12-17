package Seminar_8.MVP.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservationDate, int tableNo, String name);
    void onChangeReservationTable(int oldReservationId, Date reservationDate, int tableNo, String name);

}
