package com.company;

// Интерфейс Worker
interface Worker {
    default void work() {
        System.out.println("Работаю по умолчанию");
    }
    void performDuties();
}

// Базовый класс Person
class Person {
    protected String name;
    protected String surname;
    protected String gender;
    protected boolean active;

    public Person(String name, String surname, String gender, boolean active) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.active = active;
    }

    public void sleep() {
        System.out.println(name + " спит.");
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

// Класс Employee, наследуется от Person и реализует Worker
class Employee extends Person implements Worker {
    protected String position;
    protected double payment;
    protected int experience;
    protected String department;

    public Employee(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department) {
        super(name, surname, gender, active);
        this.position = position;
        this.payment = payment;
        this.experience = experience;
        this.department = department;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " выполняет рабочие обязанности.");
    }

    // Геттеры и сеттеры
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getPayment() { return payment; }
    public void setPayment(double payment) { this.payment = payment; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

// Кухонный работник
class KitchenWorker extends Employee {
    private String kitchenSection;

    public KitchenWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String kitchenSection) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.kitchenSection = kitchenSection;
    }

    @Override
    public void work() {
        System.out.println(name + " готовит еду на участке: " + kitchenSection);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " выполняет работу на кухне.");
    }
}

// Офисный работник
class OfficeWorker extends Employee {
    private String officeNumber;

    public OfficeWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String officeNumber) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.officeNumber = officeNumber;
    }

    @Override
    public void work() {
        System.out.println(name + " работает в офисе № " + officeNumber);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " выполняет офисные задачи.");
    }
}

// Охранник
class GuardWorker extends Employee {
    private String shiftTime;

    public GuardWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String shiftTime) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.shiftTime = shiftTime;
    }
    @Override
    public void work() {
        System.out.println(name + " охраняет территорию в смену: " + shiftTime);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " следит за порядком.");
    }
}

// Тестовый класс
public class Main {
    public static void main(String[] args) {
        KitchenWorker cook = new KitchenWorker("Иван", "Иванов", "Мужской", true, "Повар", 50000, 5, "Кухня", "Горячий цех");
        OfficeWorker officeWorker = new OfficeWorker("Анна", "Петрова", "Женский", true, "Секретарь", 40000, 3, "Офис", "101");
        GuardWorker guard = new GuardWorker("Сергей", "Сидоров", "Мужской", true, "Охранник", 45000, 7, "Охрана", "Ночная смена");

        cook.work();
        officeWorker.work();
        guard.work();
    }
}