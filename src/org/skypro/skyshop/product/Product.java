package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public class Product implements Searchable {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым.");
        }
        this.name = name;
        this.cost = cost;
    }

    public Product(String name) {
        this(name, 0);
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public int getPrice() {
        return cost;
    }

    public boolean isSpecial() {
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Продукт:  " + name;
    }
}
