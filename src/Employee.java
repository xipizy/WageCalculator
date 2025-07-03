package src;

public class Employee {
    private String name;
    private String PAYE;
    private boolean studentLoan = false;
    private int kiwiSaver;
    private int rate;

    public Employee(String name, String PAYE, boolean studentLoan, int kiwiSaver, int rate) {
        this.name = name;
        this.PAYE = PAYE;
        this.studentLoan = studentLoan;
        this.kiwiSaver = kiwiSaver;
        this.rate = rate;
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

    public int getRate() {
        return rate;
    }
}
