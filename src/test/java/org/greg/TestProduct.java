package org.greg;

import org.greg.exceptions.InvalidProductCompositionException;
import org.greg.exceptions.InvalidProductException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class TestProduct {

    @Test
    public void TestProductInequality() throws InvalidProductException {
        Product bread = ProductFactory.generate("bread");
        Product milk = ProductFactory.generate(("milk"));

        Assert.assertFalse(bread.equals(milk));
        Assert.assertFalse(milk.equals(bread));
    }


    @Test
    public void TestProductEquality() throws InvalidProductException {
        Product product1 = ProductFactory.generate("milk");
        Product product2 = ProductFactory.generate(("milk"));

        Assert.assertTrue(product1.equals(product1));
        Assert.assertTrue(product1.equals(product2));
        Assert.assertTrue(product2.equals(product1));
    }
}