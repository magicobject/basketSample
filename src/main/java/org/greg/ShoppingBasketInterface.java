package org.greg;

public interface ShoppingBasketInterface {
    public void addLineItem(LineItem lineItem);
    public int subTotal();
    public int count(Product product);
    public boolean contains(Product product);
}
