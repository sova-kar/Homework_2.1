package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0.");
        }
        this.basePrice = basePrice;

        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть больше, либо равна 0 и меньше, либо равна 100.");
        }
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public int getPrice() {
        return (basePrice * (100 - discount) / 100);
    }

    @Override
    public String toString() {
        return "Продукт: " + getName();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

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
}
