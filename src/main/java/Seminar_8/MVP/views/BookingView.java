package Seminar_8.MVP.views;

import Seminar_8.MVP.models.Table ;
import Seminar_8.MVP.presenters.View ;
import Seminar_8.MVP.presenters.ViewObserver ;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    /**
     * Отобразить список столиков
     * @param tables столики
     */
    public void showTables(Collection<Table> tables){
        for (Table table: tables){
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие пользователя (пользователь нажал на кнопку бронирования), бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * Метод изменения брони столика
     * @param oldReservation номер старой брони
     * @param reservationDate дата новой брони
     * @param tableNo номер столика
     * @param name имя пользователя
     */
    public void  changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

    public void printReservationTableResult(int reservationNo, String name){
        System.out.printf("%s, Ваш столик успешно забронирован. Номер вашей брони #%d\n", name, reservationNo);
    }


}
