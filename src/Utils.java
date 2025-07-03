package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    
    public static Scanner scanner = new Scanner(System.in);

    public static List<String> readPAYE() {
        return readCsv("./resources/PAYETable.csv");
    }

    public static List<String> readEmployee() {
        return readCsv("./resources/EmployeeDetails.csv");
    }

    private static List<String> readCsv(String fileName) {
        List<String> result = new LinkedList<>();

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) { //until the file has lines
                result.add(line); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    return result;
    }

    public static String[] convertData(String line) {
        String[] result = line.split(",");
        return result;
    }
}
