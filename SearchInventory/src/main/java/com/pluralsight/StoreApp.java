package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class StoreApp {
    private final static String inFile = "inventory.csv";

    public static ArrayList<Product> inventory = new ArrayList<Product>(); // Can be inferred like ArrayList<Product> inventory = new ArrayList<>(); or var inventory = new ArrayList<Product>();

    public static void main(String[] args) throws IOException {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("We carry the following inventory: ");

        LookupProductsByPriceRange();

    }

    /**
     * prompt the user for an ID to search for,
     * if found,
     *          display product detail.
     *          then return
     * if not found,
     *          display product could not be found
     *          then return
     */
    public static void LookupProductById(){

    }

    /**
     * prompt user for price range (minumum, maximum)
     * if found, display product detail for all matches and then return
     * if not found, display product could not be found then return
     */
    public static void LookupProductsByPriceRange(){
        float min = Console.PromptForFloat("Enter Min: ");
        float max = Console.PromptForFloat("Enter Max: ");

        for (Product i : inventory) {
            if (i.getPrice() < max && i.getPrice() > min) {
                System.out.println(i.getName());
            }
        }


    }

    /**
     * prompt user for ProductId, ProductName, and ProductPrice,
     * create a product and add it to ArrayList
     */
    public static void AddNewProduct(){

    }


    public static ArrayList<Product> getInventory() {
        try{

            BufferedReader br = new BufferedReader( new FileReader(inFile));

            String input;
            while( (input = br.readLine()) != null){
                String[] tokens = input.split("\\|");
                inventory.add(new Product(Integer.parseInt(tokens[0]), tokens[1], Float.parseFloat(tokens[2])));
            }

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

}