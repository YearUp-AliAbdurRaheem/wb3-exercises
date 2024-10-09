package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {
                "Ali", "George"
        };

        try {
            System.out.print("Pick an index 1-2: ");
            int index = scanner.nextInt();
            index--;
            System.out.println(names[index]);

        }
        catch (Exception e) {
            System.out.println("INVALID");
        }
    }
}