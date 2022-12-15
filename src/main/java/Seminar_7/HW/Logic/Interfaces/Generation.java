package Seminar_7.HW.Logic.Interfaces;

import Seminar_7.HW.Domain.Report;

import java.util.Collection;

public interface Generation {
    void generateCommonReportTXT(Collection<Report> reports);

    void generateCommonReportPDF(Collection<Report> reports);

    void generateCommonReportCSV(Collection<Report> reports);
}
