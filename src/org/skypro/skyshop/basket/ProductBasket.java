package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductByName(String name) {
        return products.remove(name);
    }

    public double getTotalCost() {
        return products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        products.forEach((name, productList) -> {
            System.out.println(name + ": " + productList.size() + " шт.");
            productList.forEach(product -> System.out.println("  " + product));
        });

        int specialCount = getSpecialCount();
        System.out.println("Количество специальных продуктов: " + specialCount);
    }
    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
