package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
        try {
            Product errorProdact = new Product(" ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            SimpleProduct erroeSimplePriduct = new SimpleProduct("Киви", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            DiscountedProduct errorDiscountedProduct = new DiscountedProduct("Арбуз", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        ProductBasket basket = new ProductBasket();

        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct bread = new SimpleProduct("Хлеб", 30);
        SimpleProduct milk = new SimpleProduct("Молоко", 80);
        SimpleProduct cheese = new SimpleProduct("Сыр", 120);
        SimpleProduct butter = new SimpleProduct("Масло", 70);
        SimpleProduct juice = new SimpleProduct("Сок", 90);
        SimpleProduct marmalade = new SimpleProduct("Мармелад", 15);
        DiscountedProduct carrot = new DiscountedProduct("Морковь", 90, 20);
        DiscountedProduct melon = new DiscountedProduct("Дыня", 90, 20);
        FixPriceProduct potato = new FixPriceProduct("Картошка");

        SearchEngine searchEngine = new SearchEngine(20);

        searchEngine.add(new Product("Капуста", 300));
        searchEngine.add(new Product("Крахмал", 300));
        searchEngine.add(new Product("Клубника", 300));
        searchEngine.add(melon);
        searchEngine.add(marmalade);

        searchEngine.add(new Article("1000 рецептов", "Рецепты со всех стран мира из капусты"));
        searchEngine.add(new Article("Недооцененный продукт", "Народные рецепты использования крахмала"));
        searchEngine.add(new Article("Ягода года", "Полезные свойства клубники"));

        try {
            Searchable bestMatch = searchEngine.findBestMatch("1000 рецептов");
            System.out.println("Найден лучший продукт: " + bestMatch.toString());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка" + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Мармелад");
            System.out.println("Найден лучший продукт: " + bestMatch.getName());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка" + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("");
            System.out.println("Найден лучший продукт: " + bestMatch.getName());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка" + e.getMessage());
        }
        System.out.println("Проверка завершена");


//        System.out.println("Результаты поиска по запросу 'Капуста':");
//        Searchable[] results = searchEngine.search("Капуста");
//        for (Searchable result : results) {
//            if (result != null) {
//                System.out.println(result.getStringRepresentation());
//            }
//        }

//        System.out.println("Результаты поиска по запросу 'Крахмал':");
//        results = searchEngine.search("Крахмал");
//        for (Searchable result : results) {
//            if (result != null) {
//                System.out.println(result.getStringRepresentation());
//            }
//        }

//        System.out.println("Результаты поиска по запросу 'Клубника':");
//        results = searchEngine.search("Клубника");
//        for (Searchable result : results) {
//            if (result != null) {
//                System.out.println(result.getStringRepresentation());
//            }
//        }System.out.println("Результаты поиска по запросу 'Тыква':");
//        results = searchEngine.search("Тыква");
//        for (Searchable result : results) {
//            if (result != null) {
//                System.out.println(result.getStringRepresentation());
//            }
//        }
//
//
//        basket.addProduct(apple);
//        basket.addProduct(bread);
//        basket.addProduct(milk);
//        basket.addProduct(cheese);
//        basket.addProduct(butter);
//        basket.addProduct(juice);
//        basket.addProduct(carrot);
//        basket.addProduct(potato);

//        System.out.println("Содержимое корзины:");
//        basket.printBasket();

    }
}