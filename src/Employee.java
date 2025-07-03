package src;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
    private String name;
    private String PAYE;
    private boolean studentLoan = false;
    private int kiwiSaver;
    private double rate;
    private double hours = 0;

    private double gross;

    public Employee(String name, String PAYE, boolean studentLoan, int kiwiSaver, double rate) {
        this.name = name;
        this.PAYE = PAYE;
        this.studentLoan = studentLoan;
        this.kiwiSaver = kiwiSaver;
        this.rate = rate;
    }

    public void setHours(double n) {
        this.hours = n;
    }

    public void calculateGross() {
        double result;
        BigDecimal temp = new BigDecimal(this.hours * rate);
        temp = temp.setScale(2, RoundingMode.HALF_UP);
        result = temp.doubleValue();
        this.gross = result;
    }

    public double getGross() {
        return this.gross;
    }
    
    public String getName() {
        return name;
    }

    public String getPAYE() {
        return PAYE;
    }

    public boolean isStudentLoan() {
        return studentLoan;
    }

    public int getKiwiSaver() {
        return kiwiSaver;
    }   

    public double getRate() {
        return rate;
    }
}
