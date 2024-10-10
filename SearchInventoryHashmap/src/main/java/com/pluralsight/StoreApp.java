package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {

    public final static String dataFileName = "inventory.csv";
    public static HashMap<Integer, Product> inventory = getInventory();


    public static void main(String[] args) {

        while(true){
            try{

                System.out.println("What do you want to do?");
                System.out.println(" 1- List all products");
                System.out.println(" 2- Lookup a product by its id");
                System.out.println(" 3- Find all products within a price range");
                System.out.println(" 4- Add a new product");
                System.out.println(" 5- Quit the application");
                System.out.print("Enter command: ");

                byte selection = Console.PromptForByte();

                if(selection == 1){
                    ListAllProducts();
                }
                else if (selection == 2){
                    LookupProductByID();
                }
                else if (selection == 3){
                    LookupProductsByPriceRange();
                }
                else if (selection == 4){
                    AddNewProduct();
                }
                else if (selection == 5){
                    return;
                }
                else{
                    System.out.println("Invalid Command");
                }
            }
            catch(Exception e){
                System.out.println("Invalid Command");
            }
        }




    }

    /**
     * Lists all products
     */
    public static void ListAllProducts(){
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory.values()) {;
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
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
    public static void LookupProductByID(){

        try{
            short id = Console.PromptForShort("Enter a product ID: ");

            if (inventory.containsKey((int)id)) {
                Product product = inventory.get((int)id);
                System.out.printf("Product ID: %d\nName: %s\nPrice: %.2f\n", product.getId(), product.getName(), product.getPrice());
                return;
            }
            System.out.println("Product was not found");
        } catch (Exception e) {
            System.out.println("Invalid Product ID, enter a numeric value less than 60,000");
        }


    }

    /**
     * prompt user for price range (minumum, maximum)
     * if found, display product detail for all matches and then return
     * if not found, display product could not be found then return
     */
    public static void LookupProductsByPriceRange(){
        float min = Console.PromptForFloat("Enter Min: ");
        float max = Console.PromptForFloat("Enter Max: ");

        ArrayList<Product> searchedArray = new ArrayList<Product>();

        for (Product i : inventory.values()){
            if (i.getPrice() >= min &&  i.getPrice() <= max){
                System.out.println(i.getName());
                searchedArray.add(i);
            }
        }
        if (searchedArray.isEmpty()){
            System.out.println("No products available at this price range");
        }
    }

    /**
     * prompt user for ProductId, ProductName, and ProductPrice,
     * create a product and add it to ArrayList
     */
    public static void AddNewProduct(){
        System.out.println("\nWelcome to Add New Product Application\n");
        int productId=Console.PromptForInt("Please Enter an ID Number: ");
        String productName=Console.PromptForString("Please Enter the Product name: ");
        float productPrice= Console.PromptForFloat("Please Enter the Price: ");
        Product p = new Product(productId, productName, productPrice);
        inventory.put(p.getId(), p);
        saveInventory();
    }

    public static HashMap<Integer, Product> getInventory() {

        // this method loads product objects into inventory
        // and its details are not shown
        HashMap<Integer, Product> inventory = new HashMap<>();

        try{
            //System.out.println(dataFileName);
            BufferedReader br = new BufferedReader( new FileReader("inventory.csv"));

            String input;
            while( (input = br.readLine()) != null){
                String[] tokens = input.split("\\|");

                Product product = new Product(Integer.parseInt(tokens[0]), tokens[1], Float.parseFloat(tokens[2]));
                //System.out.println(product.toString());

                //assert inventory != null; // i think this errs if its null
                inventory.put(product.getId(), product);
            }

            br.close();

        }
        catch(Exception e){
            System.out.println("ERROR!!");
            //e.printStackTrace();
        }

        return inventory;
    }


    public static void saveInventory(){

        try{

            FileWriter fw = new FileWriter(dataFileName);

            for(Product p : inventory.values()){
                String data = p.getId() + "|" + p.getName() + "|" + p.getPrice() + "\n";
                fw.write(data);
            }


            fw.close();
        } catch (Exception e) {
            System.out.println("FILE WRITE ERROR");
        }

    }
}