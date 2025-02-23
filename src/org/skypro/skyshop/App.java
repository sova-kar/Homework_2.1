package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class App {
    public static void main(String[] args) {
//        try {
//            Product errorProdact = new Product(" ", 100);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//        try {
//            SimpleProduct erroeSimplePriduct = new SimpleProduct("Киви", -1);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//        try {
//            DiscountedProduct errorDiscountedProduct = new DiscountedProduct("Арбуз", 100, 150);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }

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

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(new Product("Капуста", 300));
        searchEngine.add(new Product("Крахмал", 300));
        searchEngine.add(new Product("Клубника", 300));
        searchEngine.add(melon);
        searchEngine.add(marmalade);

        searchEngine.add(new Article("1000 рецептов", "Рецепты со всех стран мира из капусты"));
        searchEngine.add(new Article("Недооцененный продукт", "Народные рецепты использования крахмала"));
        searchEngine.add(new Article("Ягода года", "Полезные свойства клубники"));

//        try {
//            Searchable bestMatch = searchEngine.findBestMatch("1000 рецептов");
//            System.out.println("Найден лучший продукт: " + bestMatch.toString());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка" + e.getMessage());
//        }
//
//        try {
//            Searchable bestMatch = searchEngine.findBestMatch("Мармелад");
//            System.out.println("Найден лучший продукт: " + bestMatch.getName());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка" + e.getMessage());
//        }

//        try {
//            Searchable bestMatch = searchEngine.findBestMatch("");
//            System.out.println("Найден лучший продукт: " + bestMatch.getName());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка" + e.getMessage());
//        }
//        System.out.println("Проверка завершена");

        System.out.println("Результаты поиска по запросу 'К':");
        Set<Searchable> results = searchEngine.search("К");
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : results) {
                System.out.println(result.toString());
            }
        }

        System.out.println("Результаты поиска по запросу 'Клубника':");
        results = searchEngine.search("Клубника");
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : results) {
                System.out.println(result.toString());
            }
        }

        System.out.println("Результаты поиска по запросу 'Тыква':");
        results = searchEngine.search("Тыква");
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : results) {
                System.out.println(result.toString());
            }
        }

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

        System.out.println("Удаление продукта 'Молоко':");
        List<Product> removedProducts = basket.removeProductByName("Молоко");
        if (removedProducts != null && !removedProducts.isEmpty()) {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("Список пуст.");
        }

        System.out.println("Содержимое корзины после удаления:");
        basket.printBasket();

        System.out.println("Удаление продукта 'Ананас':");
        removedProducts = basket.removeProductByName("Ананас");
        if (removedProducts != null && !removedProducts.isEmpty()) {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("Список пуст.");
        }

        System.out.println("Содержимое корзины после удаления:");
        basket.printBasket();
    }
}
