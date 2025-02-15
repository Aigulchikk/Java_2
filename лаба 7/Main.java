package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Product {
    String name;
    double price;
    double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s - Цена: %.2f, Вес: %.2f кг", name, price, weight);
    }
}

enum ProductName {
    APPLE, BANANA, ORANGE, GRAPE, WATERMELON, PINEAPPLE, MANGO, STRAWBERRY, PEACH, CHERRY;

    public static ProductName getRandomProductName() {
        ProductName[] names = values();
        return names[new Random().nextInt(names.length)];
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> basket = new ArrayList<>();
        Random random = new Random();

        // Генерация случайных продуктов
        for (int i = 0; i < 15; i++) {
            String name = ProductName.getRandomProductName().name();
            double price = 5 + random.nextDouble() * 5; // 5 - 10005
            double weight = 0.5 + random.nextDouble() * 10; // 0.5 - 10 кг
            Product newProduct = new Product(name, price, weight);

            // Проверка на дубликат
            if (!basket.stream().anyMatch(p -> p.name.equals(newProduct.name))) {
                basket.add(newProduct);
            }
        }

        System.out.println("Исходная корзина:");
        basket.forEach(System.out::println);

        // Удаление продуктов весом > 5 кг или стоимостью > 10000
        basket.removeIf(p -> p.weight > 5 || p.price > 10000);

        // Добавление любимого продукта на первое место
        Product favoriteProduct = new Product("MANGO", 9, 3.2);
        basket.removeIf(p -> p.name.equals(favoriteProduct.name));
        basket.add(0, favoriteProduct);

        System.out.println("\nКорзина после удаления и добавления любимого продукта:");
        basket.forEach(System.out::println);

        // Вывод продуктов стоимостью < 10 и весом > 2 кг
        System.out.println("\nПродукты с ценой < 10 и весом > 2 кг:");
        basket.stream()
                .filter(p -> p.price < 10 && p.weight > 2)
                .forEach(System.out::println);
    }
}