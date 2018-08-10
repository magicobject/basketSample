package org.greg;

import org.greg.exceptions.InvalidProductException;

/**
 * Generate products based on the product name.
 * Note that we don't subclass Product e.g. class Soup extends Product as that makes the
 * code resistent to change if you add new products.
 *
 * A possible improvement could be to cache the products once created so there is only ever one instance of a particular
 * product.
 */
public class ProductFactory {

    public static Product generate(String productName) throws InvalidProductException {
        switch (productName) {
            case "apples":
                return new Product("apples", 100);

            case "bread":
                return new Product("bread", 80);

            case "milk":
                return new Product("milk", 130);

            case "soup":
                return new Product("soup", 65);
        }
        throw new InvalidProductException("You asked for " + productName + " but that is not on the system");
    }
}
