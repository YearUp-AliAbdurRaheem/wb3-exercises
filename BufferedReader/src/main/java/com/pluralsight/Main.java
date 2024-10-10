package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*String inFile = "employees.csv";
        String outFile = "payroll-oct-2024.txt";*/
        System.out.print("Enter the name of the file employee file to process: ");
        String inFile = scanner.nextLine();
        System.out.print("Enter the name of the payroll file to create: ");
        String outFile = scanner.nextLine();


        try {

            System.out.printf("%5s %20s %10s\n", "ID", "Name", "Gross Pay");
            System.out.println("-".repeat(40));

            BufferedReader br = new BufferedReader(new FileReader(inFile));
            br.readLine(); // Skip the header

            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            bw.write("id|name|gross pay"+"\n");

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
                bw.write(String.valueOf(employee.getEmployeeId())+ "|" +
                        employee.getName()+ "|" +
                        employee.getGrossPay()+ "\n");
            }

            br.close();
            bw.close();
        } catch (Exception e) {
            System.out.println("Whoops, we can't do that." + e.getMessage()); // Debugging
        }
    }
}