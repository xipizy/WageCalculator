package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// The PAYE Table only contains data between $1100 and $1320
public class Main {
    public static void main(String[] args) {
        List<String> PAYEdata = Utils.readPAYE();
        List<String> employeeData = Utils.readEmployee();
        List<Employee> employees = new ArrayList<>();
        HashMap<String, List<String>> PAYE = new HashMap<>();

        // Create new employee instances based on employeeData
        for (String n :  employeeData) {
            boolean temp;
            String[] data = Utils.convertData(n);
            if (data[2].equals("true")) {
                temp = true;
            } else {
                temp = false;
            }
            Employee employee = new Employee(data[0], data[1], temp, Integer.valueOf(data[3]), Double.valueOf(data[4]), data[5]);
            employees.add(employee);
        }

        // Filling out hashmap from PAYE Data. Gross is key, all other values will be set as the values
        for (String n : PAYEdata) {
            List<String> otherValues = new ArrayList<>();
            String[] data = Utils.convertData(n);
            String gross = data[0];
            for (int i = 1; i < data.length; i++) {
                otherValues.add(data[i]);
            }
            PAYE.putIfAbsent(gross, otherValues);
        }

        // Asking user for hours, if negative, throws exception.
        for (Employee n : employees) {
            boolean valid = false;
            double hours = 0;

            while (!valid) {
                try {
                    System.out.println("Type in the hours for " + n.getName());
                    hours = Double.valueOf(Utils.scanner.nextLine());
                    Main.checkIfNumberIsValid(hours);
                    valid = true;
                } catch (NegativeHoursException e) {
                    System.out.println("Number must be greater than 0, try again");
                }
            }
            n.setHours(hours);
            n.calculateGross();
        }

        // Calculates after tax result
        
        for (Employee n : employees) {
            double gross = n.getGross();
            int grossRounded = (int) Math.floor(gross);
            String grossRoundedString = String.valueOf(grossRounded);
            grossRoundedString = grossRoundedString + ".00";
            List<String> data = PAYE.get(grossRoundedString);
            
            // Getting PAYEtax from HashMap
            String PAYEtax;
            if (n.getPAYE().equals("M")) {
                PAYEtax = data.get(0);
            } else {
                PAYEtax = data.get(1);
            }
            n.setPAYEtax(PAYEtax);


            // Getting Student Loan
            String studentLoanTax = "0";
            if (n.isStudentLoan()) {
                studentLoanTax = data.get(2);
            }
            n.setStudentLoanTax(studentLoanTax);

            // Getting Kiwi Saver
            String kiwiSaverTax;
            switch (n.getKiwiSaverCode()) {
                case 3:
                    kiwiSaverTax = data.get(3);
                    break;
                case 4:
                    kiwiSaverTax = data.get(4);
                    break;
                case 6:
                    kiwiSaverTax = data.get(5);
                case 8:
                    kiwiSaverTax = data.get(6);
                    break;
                case 10:
                    kiwiSaverTax = data.get(7);
                    break;
                default:
                    kiwiSaverTax = "0";
            }
            n.setKiwiSaver(kiwiSaverTax);

            // Calculates after tax
            double totalMoney = n.getGross() - Double.valueOf(PAYEtax) - Double.valueOf(studentLoanTax) - Double.valueOf(kiwiSaverTax);

            // Removes 0.099999999 if present
            BigDecimal bd = new BigDecimal(totalMoney);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            totalMoney = bd.doubleValue();
            System.out.println(totalMoney);
        }
    }

    private static void checkIfNumberIsValid(double n) {
        if (n < 0) {
            throw new NegativeHoursException();
        }
    }
}
