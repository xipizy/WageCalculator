package src;

import java.util.List;

// The PAYE Table only contains data between $1100 and $1320
public class Main {
    public static void main(String[] args) {

        List<String> PAYEdata = Utils.readPAYE();
        List<String> EmployeeData = Utils.readEmployee();
        System.out.println(EmployeeData);
    }
}
