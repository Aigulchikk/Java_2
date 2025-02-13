package com.company;


class shop {
    int cashRegisters; // Количество касс
    Product[] products; // Массив продуктов
    int sellers; // Количество продавцов

    // Вложенный класс Товар
    static class Product {
        double weight; // Вес товара
        double price;  // Цена товара

        // Конструктор: что такое товар
        public Product(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }
    }

    // Конструктор магазина: создаём магазин
    public shop(int cashRegisters, Product[] products, int sellers) {
        this.cashRegisters = cashRegisters;
        this.products = products;
        this.sellers = sellers;
    }

    // Метод для подсчёта среднего веса товара
    public double calculateAverageWeight() {
        double totalWeight = 0; // Сумма всех весов
        for (int i = 0; i < products.length; i++) {
            totalWeight += products[i].weight; // Суммируем вес каждого товара
        }
        return totalWeight / products.length; // Средний вес
    }

    // Метод для подсчёта эффективности кассы
    public double calculateCashRegisterEfficiency() {
        return (double) sellers / cashRegisters; // Продавцы делятся на кассы
    }

    // Метод для подсчёта общей эффективности
    public double calculateEfficiency() {
        double averageWeight = calculateAverageWeight(); // Вызываем метод для веса
        double cashEfficiency = calculateCashRegisterEfficiency(); // Вызываем метод для касс
        return averageWeight * cashEfficiency; // Умножаем результаты
    }

    // Метод для вывода информации о магазине
    public void displayInfo() {
        System.out.println("Количество касс: " + cashRegisters);
        System.out.println("Количество продавцов: " + sellers);
        System.out.println("Эффективность магазина: " + calculateEfficiency());
    }
}

// Класс Супермаркет
class Supermarket extends shop {
    double area; // Площадь супермаркета
    String[] categories; // Категории товаров

    // Конструктор супермаркета
    public Supermarket(int cashRegisters, Product[] products, int sellers, double area, String[] categories) {
        super(cashRegisters, products, sellers); // Вызов конструктора магазина
        this.area = area;
        this.categories = categories;
    }

    // Метод для подсчёта эффективности супермаркета
    @Override
    public double calculateEfficiency() {
        double baseEfficiency = super.calculateCashRegisterEfficiency(); // Эффективность касс
        double categoryImpact = area / categories.length; // Влияние площади и категорий
        return baseEfficiency * categoryImpact;
    }

    // Метод для вывода информации о супермаркете
    @Override
    public void displayInfo() {
        super.displayInfo(); // Вывод информации о магазине
        System.out.println("Площадь супермаркета: " + area);
        System.out.println("Категории товаров: " + String.join(", ", categories));
        System.out.println("Эффективность супермаркета: " + calculateEfficiency());
    }
}
public class Main {
    public static void main(String[] args) {
        // Создаём несколько товаров
        shop.Product product1 = new shop.Product(1.5, 10.0);
        shop.Product product2 = new shop.Product(2.0, 15.0);
        shop.Product product3 = new shop.Product(3.0, 20.0);

        // Помещаем товары в массив
        shop.Product[] products = {product1, product2, product3};

        // Создаём обычный магазин
        shop shop = new shop(2, products, 4);
        System.out.println("Информация о магазине:");
        shop.displayInfo(); // Выводим информацию о магазине

        System.out.println();

        // Создаём супермаркет
        String[] categories = {"Продукты", "Одежда", "Электроника"};
        Supermarket supermarket = new Supermarket(3, products, 6, 500.0, categories);
        System.out.println("Информация о супермаркете:");
        supermarket.displayInfo(); // Выводим информацию о супермаркете
    }
}

