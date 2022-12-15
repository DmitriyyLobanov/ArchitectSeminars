package Seminar_7.HW;

import Seminar_7.HW.Logic.ReportGenerator;
import Seminar_7.HW.Domain.Report;
import Seminar_7.HW.Domain.ReportsContainer;

import java.util.Scanner;

/***
 *     ДОМАШНЯЯ РАБОТА
 *     Необходимо спроектировать сервис отчётов для компании оптовой торговли.
 *     а. Доменная модель (компания, товарные категории, табличный отчёт,
 *         графики и диаграммы, финансовые показатели, ..), в виде текста Домен – атрибуты.
 *     b. Сформировать компоненты бизнес-логики (функциональные) необходимые для построения этих отчётов.
 */

public class Application {
    public static void main(String[] args) {

        ReportsContainer rc = new ReportsContainer();
        ReportGenerator rg = new ReportGenerator();

        //rg.randomRecordGeneration(rc.getReportCollection());
        //rg.showCommonReportInConsole(rc.getReportCollection());
        //rg.generateCommonReportTXT(rc.getReportCollection());

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("|||Создание отчета|||");
            System.out.println("______________________");
            System.out.println("1 - Сгенерировать базу для отчета.");
            System.out.println("2- Создать и показать общий отчет в консоль.(Без сохранения)");
            System.out.println("3- Создать и сохранить отчет в .txt");
            System.out.println("0 - Завершение работы.");
            System.out.println("Выберите пунткт меню.");
            if(scanner.hasNextInt()){
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (userChoice){
                        case 0:
                            System.out.println("Завершение работы.");
                            flag = false;
                            break;
                        case 1:
                            rg.randomRecordGeneration(rc.getReportCollection());
                            System.out.println("Случайная база сгенерирована.");
                            break;
                        case 2:
                            rg.showCommonReportInConsole(rc.getReportCollection());
                            break;
                        case 3:
                            rg.generateCommonReportTXT(rc.getReportCollection());
                            System.out.println("Файл с отчетом создан.");
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню!");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }

    }
}
