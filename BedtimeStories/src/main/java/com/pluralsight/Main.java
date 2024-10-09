package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInputString;
        String userSelection = "";
        do {
            try {
    
               
                    System.out.println("Welcome to the story collective!");
                    System.out.print("Please enter a story name or [Q]uit\n>>> ");
                    userInputString = scanner.nextLine();
                    switch (userInputString.toLowerCase()) {
                        case "goldilocks", "g":
                            userSelection = "goldilocks.txt"; break;
                        case "hansel_and_gretel", "hansel and gretel", "h":
                            userSelection = "hansel_and_gretel.txt"; break;
                        case "mary_had_a_little_lamb", "mary had a little lamb", "m":
                            userSelection = "mary_had_a_little_lamb.txt"; break;
                        case "q":
                            return;
                    }
    
                    FileInputStream fis = new FileInputStream(userSelection);
                    Scanner scanFile = new Scanner(fis);
                    int lineNumber = 1;
                    while(scanFile.hasNextLine()){
                        String line = scanFile.nextLine();
                        System.out.printf("%d: %s\n", lineNumber++, line);
                    }

                scanFile.close();
                
            }
            catch(Exception e){
                System.out.println("Whoops, we can't do that." + e.getMessage());
            }
        } while (true);
    }
}