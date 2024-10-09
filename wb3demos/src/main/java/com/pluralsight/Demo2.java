package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) throws FileNotFoundException {


        try{

            FileInputStream fis = new FileInputStream("poem.txt");
            Scanner scanner = new Scanner(fis);
            int lineNumber = 1;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.printf("%d: %s\n", lineNumber++, line);
            }

            scanner.close();
        }
        catch(Exception e){
            System.out.println("Whoops, we can't do that.");
        }


    }
}