package org.greg;

import org.junit.Assert;
import org.junit.Test;

public class TestBasketDiscountService {
    @Test
    public void testBasketWithNoDiscounts() {
        try {
            Product bread = ProductFactory.generate("bread");
            Product milk = ProductFactory.generate("milk");
            Product soup = ProductFactory.generate("soup");

            ShoppingBasket basket = new ShoppingBasket();

            basket.addLineItem(new LineItem(bread, 1));
            basket.addLineItem(new LineItem(milk, 1));
            basket.addLineItem(new LineItem(soup, 1));

            BasketDiscountService basketDiscountService = new BasketDiscountService();

            int basketPrice = basket.subTotal();
            int discount = basketDiscountService.getDiscount(basket);

            Assert.assertEquals(275, basketPrice - discount);
        } catch (Exception exc) {
            Assert.fail("Unexpected exception " + exc.getClass().getName());
        }
    }

    @Test
    public void testBasketWithApplesDiscount() {
        try {
            Product apples = ProductFactory.generate("apples");
            Product milk = ProductFactory.generate("milk");
            Product soup = ProductFactory.generate("soup");

            ShoppingBasket basket = new ShoppingBasket();

            basket.addLineItem(new LineItem(apples, 1));
            basket.addLineItem(new LineItem(milk, 1));
            basket.addLineItem(new LineItem(soup, 1));

            BasketDiscountService basketDiscountService = new BasketDiscountService();
            int basketPrice = basket.subTotal();
            int discount = basketDiscountService.getDiscount(basket);

            Assert.assertEquals(285, basketPrice - discount);
        } catch (Exception exc) {
            Assert.fail("Unexpected exception " + exc.getClass().getName());
        }
    }

    @Test
    public void testBasketWithSoupAndBreadNoDiscount() {
        try {
            Product soup = ProductFactory.generate("soup");
            Product bread = ProductFactory.generate("bread");

            ShoppingBasket basket = new ShoppingBasket();

            basket.addLineItem(new LineItem(soup, 1));
            basket.addLineItem(new LineItem(bread, 1));

            BasketDiscountService basketDiscountService = new BasketDiscountService();
            int basketPrice = basket.subTotal();
            int discount = basketDiscountService.getDiscount(basket);

            Assert.assertEquals(145, basketPrice - discount);
        } catch (Exception exc) {
            Assert.fail("Unexpected exception " + exc.getClass().getName());
        }
    }

    @Test
    public void testBasketWithSoupAndBreadWithDiscount() {
        try {
            Product soup = ProductFactory.generate("soup");
            Product bread = ProductFactory.generate("bread");

            ShoppingBasket basket = new ShoppingBasket();

            basket.addLineItem(new LineItem(soup, 2));
            basket.addLineItem(new LineItem(bread, 1));

            BasketDiscountService basketDiscountService = new BasketDiscountService();
            int basketPrice = basket.subTotal();
            int discount = basketDiscountService.getDiscount(basket);

            Assert.assertEquals(170, basketPrice - discount);
        } catch (Exception exc) {
            Assert.fail("Unexpected exception " + exc.getClass().getName());
        }
    }
}
