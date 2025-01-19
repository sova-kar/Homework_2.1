package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basePrice == that.basePrice && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discount);
    }

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name, basePrice);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (basePrice * (100 - discount) / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
