package org.greg;

import org.greg.exceptions.InvalidProductCompositionException;
import org.greg.exceptions.InvalidProductException;
import org.junit.Assert;
import org.junit.Test;

public class TestLineItem {

    @Test
    public void Test5BagsOfApplesCosts5Pounds() {
        try {
            ProductFactory productFactory = new ProductFactory();
            Product apples = productFactory.generate("apples");
            LineItem lineItem = new LineItem(apples, 5);

            Assert.assertEquals(500, lineItem.subTotal()); // Can't add a message here :(
        } catch (InvalidProductException exc) {
            Assert.fail("Unexpected " + InvalidProductException.class);
        }
    }

    @Test
    public void TestAddingApplesToSoupFails() {
        try {
            ProductFactory productFactory = new ProductFactory();

            Product apples = productFactory.generate("apples");
            LineItem applesLineItem = new LineItem(apples, 5);

            Product soup = productFactory.generate("soup");
            LineItem soupLineItem = new LineItem(soup, 3);

            soupLineItem.add(applesLineItem);
            Assert.fail("I added apples to soup but didn't get an exception");
        } catch (InvalidProductCompositionException exc) {
            // Expected
        } catch (InvalidProductException exc) {
            Assert.fail("unexpected " + InvalidProductException.class);
        }
    }

    @Test
    public void TestAddingApplesToApplesSucceeds() {
        try {
            ProductFactory productFactory = new ProductFactory();

            Product apples = productFactory.generate("apples");
            LineItem fiveApples = new LineItem(apples, 5);
            LineItem threeApples = new LineItem(apples, 3);

            fiveApples.add(threeApples);

            Assert.assertEquals(8, fiveApples.getQuantity());

        } catch (Exception exc) {
            Assert.fail("unexpected " + exc.getClass().getName());
        }
    }
}
