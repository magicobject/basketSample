package org.greg;

import org.greg.exceptions.InvalidProductException;

import java.util.ArrayList;

/**
 * Load products into the basket then print the basket along with discounts
 */
public class Application {

    public static void main(String[] argv) {

        if (argv.length == 0) {
            // Nothing to do - could add error message
            return;
        }

        ShoppingBasket basket = new ShoppingBasket();

        try {
            addProductsToBasket(argv, basket);
        } catch (InvalidProductException exc) {
            System.out.println(exc.getMessage());
            return;
        }

        printBasket(basket);

    }

    /**
     * @param basket
     */
    private static void printBasket(ShoppingBasket basket) {
        int basketTotalPence = basket.subTotal();
        BasketDiscountService basketDiscountService = new BasketDiscountService();
        int discountPence = basketDiscountService.getDiscount(basket);
        ArrayList<String> discountMessages = basketDiscountService.getDiscountMessages();

        System.out.printf("Subtotal: £%.2f\n", (float)basketTotalPence/100.0);
        if (discountMessages.isEmpty()) {
            System.out.println("(no offers available)");
        } else {
            for (String discountMessage : discountMessages) {
                System.out.println(discountMessage);
            }
        }
        System.out.printf("Total: £%.2f\n", (float)(basketTotalPence - discountPence)/100.0);
    }

    /**
     * @param argv
     * @param basket
     * @throws InvalidProductException
     */
    private static void addProductsToBasket(String[] argv, ShoppingBasket basket) throws InvalidProductException {
        for( String productName : argv) {
            Product product = ProductFactory.generate(productName.toLowerCase());
            LineItem lineItem = new LineItem(product, 1);
            basket.addLineItem(lineItem);
        }
    }
}
