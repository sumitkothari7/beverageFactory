package com.smoothiecorner;

import com.smoothiecorner.exception.IngredientNotFoundException;
import com.smoothiecorner.exception.InvalidOrderException;
import com.smoothiecorner.exception.MenuItemNotFoundException;
import com.smoothiecorner.order.OrderProcessor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.println("To remove ingredient use - (MINUS) eg -sugar");
        System.out.println("To Exit console type exit and enter");
        System.out.println();
        String order = scanner.nextLine();

        while (!"exit".equalsIgnoreCase(order)) {
            if ("menu".equalsIgnoreCase(order)) {
                printMenu();
            } else {
                OrderProcessor processor = new OrderProcessor();
                try {
                    double orderAmount = processor.processOrder(order);
                    System.out.println("Order amount is :: " + orderAmount);
                } catch (InvalidOrderException e) {
                    System.out.println(" Your order is invalid");
                } catch (MenuItemNotFoundException e) {
                    System.out.println("Ordered menu item not available");
                } catch (IngredientNotFoundException e) {
                    System.out.println("Ingredient not available");
                }
            }
            order = scanner.nextLine();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("********* Menu ***********");
        System.out.println("1. coffee (coffee, sugar, milk, water)  : $5.0");
        System.out.println("2. chai (tea, sugar, milk, water)  : $4.0");
        System.out.println("3. BananaSmoothie (banana, sugar, milk, water)  : $6.0");
        System.out.println("4. StrawberryShake (strawberries, sugar, milk, water)  : $7.0");
        System.out.println("5. Mojito (lemon, sugar, mint, water, soda)  : $7.5");
        System.out.println("**************************");
        System.out.println("Ingredients ");
        System.out.println("sugar ($0.5), milk ($1), water ($0.5), soda ($0.5), mint ($0.5)");
        System.out.println("**************************");
        System.out.println("type menu to reprint menu");
        System.out.println("Enter your order");
    }
}
