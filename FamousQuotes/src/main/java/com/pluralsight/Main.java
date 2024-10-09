package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final String[] QUOTES = {
                "All right, Mr. DeMille, I'm ready for my closeup.",
                "Frankly, my dear, I don’t give a damn.",
                "Go ahead, make my day.",
                "Here's looking at you, kid.",
                "I love the smell of napalm in the morning.",
                "I'm going to make him an offer he can't refuse.",
                "May the Force be with you.",
                "Toto, I've got a feeling we're not in Kansas anymore.",
                "What we've got here is failure to communicate.",
                "You talking to me?"
        };

        System.out.println("Welcome to Famous Quotes!");

        while (true) {

            System.out.print("Enter a number to get a quote or a (r)andom one:\n>>> ");

            try {
                String userInputString = scanner.nextLine();
                if (userInputString.equalsIgnoreCase("r")) {
                    System.out.println(QUOTES[random.nextInt(10) +1]); continue;
                }
                int index = Integer.parseInt(userInputString);
                System.out.println(QUOTES[--index]);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid Index! Please try again!");
            }
            catch (NumberFormatException e) {
                System.out.println("Not a Number! Please try again!");
            }
        }


    }
}