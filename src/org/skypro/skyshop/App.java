package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct bread = new SimpleProduct("Хлеб", 30);
        SimpleProduct milk = new SimpleProduct("Молоко", 80);
        SimpleProduct cheese = new SimpleProduct("Сыр", 120);
        SimpleProduct butter = new SimpleProduct("Масло", 70);
        SimpleProduct juice = new SimpleProduct("Сок", 90);
        DiscountedProduct carrot = new DiscountedProduct("Морковь", 90, 20);
        FixPriceProduct potato = new FixPriceProduct("Картошка");


        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);
        basket.addProduct(juice);
        basket.addProduct(carrot);
        basket.addProduct(potato);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

    }
}