package org.greg;

import org.greg.exceptions.InvalidProductException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProductFactory {

    @Test
    public void testInvalidProductRequestThrowsInvalidProductException() {
        try {
            ProductFactory.generate("I am a bad product");
            Assert.fail("I expected an " + InvalidProductException.class);
        } catch (InvalidProductException exc) {
            // This is what I'm expecting
        }
    }

    @Test
    public void requestApplesAndGetApplesProductCosting100pence() {
        try {
            Product apples = ProductFactory.generate("apples");
            Assert.assertEquals(100, apples.getPrice());
            Assert.assertEquals("apples", apples.getName());
        } catch (InvalidProductException exc) {
            Assert.fail("expected product was not generated " + exc.getMessage());
        }
    }
}
