package Seminar_8;

import Seminar_8.MVP.models.BookingModel ;
import Seminar_8.MVP.presenters.BookingPresenter ;
import Seminar_8.MVP.views.BookingView ;

import java.util.Date;

public class Sample01 {

    public static void main(String[] args) {
        BookingModel bookingModel = new BookingModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Станислав");

        bookingView.changeReservationTable(1, new Date(), 2, "Dmitriy");
        bookingView.changeReservationTable(2, new Date(), 1, "Dmitriy");
        bookingView.changeReservationTable(3, new Date(), 4, "Dmitriy");

    }

}
