package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try {

            System.out.printf("%5s %20s %10s\n", "ID", "Name", "Gross Pay");

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine(); // Skip the header

            String line = br.readLine();
            while (line != null) {
                String[] lineSplit = line.split("\\|");

                Employee employee = new Employee(
                        Integer.parseInt(lineSplit[0]),
                        lineSplit[1],
                        Double.parseDouble(lineSplit[2]),
                        Double.parseDouble(lineSplit[3])
                );

                System.out.printf("%5s %20s %10s\n",
                        String.valueOf(employee.getEmployeeId()),
                        employee.getName(),
                        employee.getGrossPay());

                line = br.readLine();
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Whoops, we can't do that." + e.getMessage());
        }
    }
}