package src;

public class Employee {
    private String name;
    private String PAYE;
    private boolean studentLoan = false;
    private int kiwiSaver;

    public Employee(String name, String PAYE, boolean studentLoan, int kiwiSaver) {
        this.name = name;
        this.PAYE = PAYE;
        this.studentLoan = studentLoan;
        this.kiwiSaver = kiwiSaver;
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
}
