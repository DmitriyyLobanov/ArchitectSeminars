package Seminar_7.HW.ConsoleUI;

import Seminar_7.HW.Domain.Report;

import java.util.Collection;

public interface ConsoleUIPresenter {
    void randomRecordGeneration(Collection<Report> reports);
    void showCommonReportInConsole(Collection<Report> reports);
    void saveReportInTXT();
    void saveReportInPDF();
    void saveReportInCSV();
}
