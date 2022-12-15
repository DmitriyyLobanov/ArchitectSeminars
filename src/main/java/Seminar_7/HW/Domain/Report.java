package Seminar_7.HW.Domain;

import java.util.Date;

public class Report {

    private static int counter;

    private int id;
    private String positionName;
    private int quantity;
    private double amount;

    private Date date;


    {
        id = ++counter;
    }

    public Report(String positionName, int quantity, double amount) {
        this.positionName = positionName;
        this.quantity = quantity;
        this.amount = amount;
        this.date = new Date();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
