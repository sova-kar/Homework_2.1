package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 30);
        Product milk = new Product("Молоко", 80);
        Product cheese = new Product("Сыр", 120);
        Product butter = new Product("Масло", 70);
        Product juice = new Product("Сок", 90);

        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);
        basket.addProduct(juice);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        String searchProduct1 = "Молоко";
        System.out.println("Есть ли " + searchProduct1 + " в корзине? " + basket.containsProduct(searchProduct1));

        String searchProduct2 = "Сок";
        System.out.println("Есть ли " + searchProduct2 + " в корзине? " + basket.containsProduct(searchProduct2));

        System.out.println("Очистка корзины...");
        basket.clearBasket();

        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        String searchProduct3 = "Хлеб";
        System.out.println("Есть ли " + searchProduct3 + " в пустой корзине? " + basket.containsProduct(searchProduct3));
    }
}