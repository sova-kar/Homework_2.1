package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE_PRODUCT = 100;

    public FixPriceProduct(String name) {
        super(name,FIX_PRICE_PRODUCT);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return "Продукт: " + getName();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
