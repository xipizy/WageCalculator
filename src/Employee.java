package src;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
    private String name;
    private String PAYE;
    private boolean studentLoan = false;
    private int kiwiSaverCode;
    private double rate;
    private double hours = 0;
    private String IRD;

    private double gross;
    private String PAYEtax;
    private String kiwiSaver;
    private String studentLoanTax;
    private String totalMoney;

    public Employee(String name, String PAYE, boolean studentLoan, int kiwiSaver, double rate, String IRD) {
        this.name = name;
        this.PAYE = PAYE;
        this.studentLoan = studentLoan;
        this.kiwiSaverCode = kiwiSaver;
        this.rate = rate;
        this.IRD = IRD;
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

    
    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStudentLoanTax() {
        return studentLoanTax;
    }

    public void setStudentLoanTax(String studentLoanTax) {
        this.studentLoanTax = studentLoanTax;
    }

    public void setPAYEtax(String n) {
        this.PAYEtax = n;
    }

    public String getPAYEtax() {
        return this.PAYEtax;
    }

    public void setKiwiSaver(String n) {
        this.kiwiSaver = n;
    }

    public String getKiwiSaver() {
        return this.kiwiSaver;
    }

    public String getIRD() {
        return IRD;
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

    public int getKiwiSaverCode() {
        return kiwiSaverCode;
    }   

    public double getRate() {
        return rate;
    }
}
