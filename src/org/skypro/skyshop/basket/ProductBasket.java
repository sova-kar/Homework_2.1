package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private Product[] products;
    private int count;

    public ProductBasket() {
        products = new Product[15];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Корзина переполнена");
        }
    }

    public double getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < count; i++) {
            if (products[i] != null) {
                totalCost += products[i].getPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (int i = 0; i < count; i++) {
                if (products[i] != null) {
                    System.out.println(products[i].toString());
                    if (products[i].isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i] != null && products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return count == that.count && Objects.deepEquals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(products), count);
    }
}

