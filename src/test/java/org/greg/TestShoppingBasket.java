package org.greg;

import org.junit.Assert;
import org.junit.Test;

public class TestShoppingBasket {
    @Test
    public void TestBasketComposition()
    {
        ShoppingBasket basket = new ShoppingBasket();

        // One of everything comes to 375 pence so 10 comes to 3750 pence
        try {
            Product apples = new ProductFactory().generate("apples");
            Product bread = new ProductFactory().generate("bread");
            Product milk = new ProductFactory().generate("milk");
            Product soup = new ProductFactory().generate("soup");
            basket.addLineItem(new LineItem(apples, 10));
            basket.addLineItem(new LineItem(bread, 1));
            basket.addLineItem(new LineItem(bread, 2));
            basket.addLineItem(new LineItem(bread, 3));
            basket.addLineItem(new LineItem(bread, 4));
            basket.addLineItem(new LineItem(milk, 10));
            basket.addLineItem(new LineItem(soup, 10));
        } catch (Exception exc) {
            Assert.fail("Unexpected exception " + exc.getClass().getName());
        }

        Assert.assertEquals(3750, basket.subTotal());
    }
}
