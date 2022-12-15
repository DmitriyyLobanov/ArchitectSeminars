package Seminar_7.HW.Logic;

import Seminar_7.HW.ConsoleUI.ConsoleUIPresenter;
import Seminar_7.HW.Logic.Interfaces.Generation;
import Seminar_7.HW.Domain.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class ReportGenerator implements Generation, ConsoleUIPresenter {

    @Override
    public void generateCommonReportTXT(Collection<Report> reports) {
        Date generateDate = new Date();
        String fileName = "ReportTXT" + "_" + generateDate.getTime();
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/Seminar_7/HW/ReportsFiles/"+
                fileName +".txt"))){
            for (Report rep: reports
                 ) {
                fileWriter.write(rep.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void generateCommonReportPDF(Collection<Report> reports) {
        //TODO
    }

    @Override
    public void generateCommonReportCSV(Collection<Report> reports) {
        //TODO
    }

    @Override
    public void randomRecordGeneration(Collection<Report> reports) {
        Random random = new Random();
        int recordAmount = random.nextInt(1, 100);
        for (int i = 0; i <= recordAmount ; i++) {
            reports.add(new Report("AnyPosition", random.nextInt(1, 1000),
                    random.nextDouble(1, 100000)));
        }
    }

    @Override
    public void showCommonReportInConsole(Collection<Report> reports) {
        for (Report r: reports
             ) {
            System.out.println(r);
        }
    }

    @Override
    public void saveReportInTXT() {

    }

    @Override
    public void saveReportInPDF() {

    }

    @Override
    public void saveReportInCSV() {

    }
}
