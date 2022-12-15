package Seminar_7.HW.Domain;

import Seminar_7.HW.Logic.Interfaces.ReportContainerisation;

import java.util.ArrayList;
import java.util.Collection;

public class ReportsContainer implements ReportContainerisation {
    private Collection<Report> reportCollection = new ArrayList<>();


    @Override
    public void addReport(Report report) {
        reportCollection.add(report);
    }

    @Override
    public void removeReport(Report report) {
        reportCollection.remove(report);
    }

    public Collection<Report> getReportCollection() {
        return reportCollection;
    }


}
