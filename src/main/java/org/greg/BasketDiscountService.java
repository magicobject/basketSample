package org.greg;

import org.greg.exceptions.InvalidProductException;

import java.util.ArrayList;

/**
 * Main discount service.
 * This needs updating to handle a set of discount methods.
 * Define a DiscountStrategyInterfeac and pass in an array of
 * DiscountStrayegies which can all be applied to the basket.
 * This makes it much easier to add/swap strategies
 */
public class BasketDiscountService implements BasketDiscountServiceInterface {

    private ArrayList<String> discountMessages = new ArrayList<>();

    /**
     * Apply each discount to the basket and return the total discount in pence
     * @param basket
     * @return
     */
    public int getDiscount(ShoppingBasketInterface basket) {
        int discount = 0;

        try {
            Product apples = ProductFactory.generate("apples");
            Product soup = ProductFactory.generate("soup");
            Product bread = ProductFactory.generate("bread");

            // Apples discount
            if (basket.contains(apples)) {
                discountMessages.add("Apples 10% off: - 10p");
                discount += basket.count(apples) * apples.getPrice() * .1; // Apples @ 10% off
            }

            // Soup and bread discount - would query with BA if this is cumulitive
            // i.e. what happens if you have 4 tins of soup and 2 loaves of bread

            if (basket.contains(bread) && basket.contains(soup)) {
                if (basket.count(soup) > 1) {
                    discountMessages.add("Soup multidiscount 50% off bread");
                    discount += bread.getPrice()/2;
                }
            }
        } catch (InvalidProductException exc)
        {
            // Safe to ignore for now
        }


        return discount;
    }

    public ArrayList<String> getDiscountMessages() {
        return discountMessages;
    }

}
