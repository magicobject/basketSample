package org.greg;


import org.greg.exceptions.InvalidProductCompositionException;

import java.util.HashSet;

/**
 *
 */
public class ShoppingBasket implements ShoppingBasketInterface {
    private HashSet<LineItem> lineItems = new HashSet<>();

    /**
     * @param lineItem
     */
    public void addLineItem(LineItem lineItem) {
        if (lineItems.contains(lineItem)) {
            for (LineItem existingLineItem : lineItems) {
                if (existingLineItem.equals(lineItem)) {
                    try {
                        existingLineItem.add(lineItem);
                        return;
                    } catch (InvalidProductCompositionException exc) {
                        // This should never happen because I'm chekcing composition in the if statement
                    }
                }
            }
        }

        lineItems.add(lineItem);
    }

    /**
     * Return the non-discounted basket subtotal in pence
     * @return
     */
    public int subTotal() {
        int subTotal = 0;
        for (LineItem item : lineItems) {
            subTotal+=item.subTotal();
        }
        return subTotal;
    }

    /**
     * Return true if the basket contains a line item with the product, false otherwise
     * @param product
     * @return
     */
    public boolean contains(Product product)
    {
        for(LineItem item: lineItems) {
            if (item.hashCode() == product.hashCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loop over all lineitems. If this product is found return the number of products in the line item
     * @param product
     * @return
     */
    public int count(Product product)
    {
        for(LineItem item: lineItems) {
            if (item.hashCode() == product.hashCode()) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    // TODO remove line item etc.

}
