package org.greg;

/**
 * Immutable product class. I'm making this final so other developers don't subclass it as this leads to a very
 * inflexible design if more products are added.
 *
 * Remember that price is an integer in pence.
 */
public final class Product {

    private String name;

    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public boolean equals(Object product) {
        if (product.getClass() != Product.class) {
            return false;
        }
        Product compareProduct = (Product)product;
        return compareProduct.name.equals(name) && compareProduct.price == price;
    }
}
