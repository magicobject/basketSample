package org.greg;

import org.greg.exceptions.InvalidProductCompositionException;

/**
 * A lineItem is a product with a quantity. We have to be able to adjust the quantity.
 */
public class LineItem {
    private Product product;

    private int quantity;

    public LineItem(Product product, int quantity) {
        // TODO throw exception if quantity < 1 - for brevity I'll assume sanity reigns
        this.product = product;
        this.quantity = quantity;
    }

    public void incermentQuantity() {
        quantity++;
    }

    public int getQuantity() {
        return quantity;
    }

    public int subTotal() {
        return quantity * product.getPrice();
    }

    public void add(LineItem newLineItem) throws InvalidProductCompositionException {
        if (newLineItem.hashCode() != hashCode()) {
            throw new InvalidProductCompositionException("You tried to add " + newLineItem.product.getName() + " to " + product.getName());
        }
        quantity = quantity + newLineItem.quantity;
    }

    // Use the product hashcode as this makes it easier to identify line-items with products
    @Override
    public int hashCode() {
        return product.hashCode();
    }

    @Override
    public boolean equals(Object lineItem) {
        return hashCode() == lineItem.hashCode();
    }
}
