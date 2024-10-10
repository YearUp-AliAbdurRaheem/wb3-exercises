package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String outFile = "logs.txt";
        // date for launch
        LocalDateTime nowLaunch = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateLaunch = nowLaunch.format(formatter);

        try {
            // Initialize bufferReader and write launch
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            bw.write(formattedDateLaunch + " launch" + "\n");

            do {
                // Question
                System.out.print("Enter a search term (X to exit): ");
                String searchTerm = scanner.nextLine();
                // getting DateTime
                LocalDateTime now = LocalDateTime.now();
                String formattedDate = now.format(formatter);

                // Check if X
                if (searchTerm.equalsIgnoreCase("X")) {
                    bw.write(formattedDate + " exit" + "\n");
                    return;
                }


                bw.write(formattedDate + searchTerm + "\n");
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}