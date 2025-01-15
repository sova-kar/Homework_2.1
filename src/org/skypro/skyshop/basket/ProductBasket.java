package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int count;

    public ProductBasket() {
        products = new Product[5];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < count; i++) {
            totalCost += products[i].getPrice();
        }
        return totalCost;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("в корзине пусто");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].getName() + ": " + products[i].getPrice());
            }
            System.out.println("Итого: " + getTotalCost());
        }
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
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
}
