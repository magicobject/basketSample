package org.greg;

import java.util.ArrayList;

/**
 * I expect the discounts to change regularly so we will eventually inject the right
 * ValuationService for today's offers.
 */
public interface BasketDiscountServiceInterface {
    public int getDiscount(ShoppingBasketInterface basket);
    public ArrayList<String> getDiscountMessages();
}
