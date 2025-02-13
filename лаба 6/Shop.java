package com.company;

// Класс Магазин
class Shop {
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
    public Shop(int cashRegisters, Product[] products, int sellers) {
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


