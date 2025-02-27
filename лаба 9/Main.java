package com.company;
import java.util.ArrayList;
import java.util.Scanner;

class NotCorrectAgeException extends Exception {
    public NotCorrectAgeException(String message) {
        super(message);
    }
}

// Студент
class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private String gender;
    private int course;
    private double averageGrade;

    public Student() {}

    public Student(String firstName, String lastName, String middleName, int age, String gender, int course, double averageGrade) throws NotCorrectAgeException {
        setAge(age);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public void setAge(int age) throws NotCorrectAgeException {
        if (age < 16 || age > 60) {
            throw new NotCorrectAgeException("Возраст должен быть в диапазоне 16-60 лет");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + ", возраст: " + age + ", курс: " + course + ", средний балл: " + averageGrade;
    }
}

// Группа
class Group {
    private static final int MAX_STUDENTS = 15;
    private static final int MIN_STUDENTS = 3;
    private ArrayList<Student> students = new ArrayList<>();
    private boolean studentAdded = false;  // Флаг для вывода сообщения один раз

    public void addStudent() {
        if (students.size() >= MAX_STUDENTS) {
            System.out.println("Ошибка: Группа уже заполнена!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Введите фамилию: ");
            String lastName = scanner.nextLine();
            System.out.print("Введите отчество: ");
            String middleName = scanner.nextLine();
            System.out.print("Введите возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите пол (М/Ж): ");
            String gender = scanner.nextLine();
            System.out.print("Введите курс: ");
            int course = scanner.nextInt();
            System.out.print("Введите средний балл: ");
            double averageGrade = scanner.nextDouble();

            Student student = new Student(firstName, lastName, middleName, age, gender, course, averageGrade);
            students.add(student);
            studentAdded = true;

        } catch (NotCorrectAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка при вводе данных!");
        }
    }

    public void addStudent(Student student) {
        if (students.size() >= MAX_STUDENTS) {
            return;
        }
        students.add(student);
        studentAdded = true;
    }

    public void removeStudent(int index) {
        if (students.size() <= MIN_STUDENTS) {
            System.out.println("Ошибка: В группе не может быть меньше " + MIN_STUDENTS + " студентов!");
            return;
        }
        if (index < 0 || index >= students.size()) {
            System.out.println("Ошибка: Неверный индекс студента!");
            return;
        }
        students.remove(index);
        System.out.println("Студент удалён.");
    }

    public Student getStudent(int index) {
        try {
            if (index < 0 || index >= students.size()) {
                throw new IndexOutOfBoundsException("Ошибка: Недопустимый номер студента!");
            }
            return students.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("Группа пуста.");
            return;
        }
        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ": " + students.get(i));
        }
    }
    
    public void showAddedStudents() {
        if (studentAdded) {
            System.out.println("Студент успешно добавлен!");
            printStudents();
            studentAdded = false;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Group group = new Group();

        try {
            group.addStudent();
            group.addStudent(new Student("Иван", "Петров", "Сергеевич", 20, "М", 2, 4.5));
            group.addStudent(new Student("Анна", "Сидорова", "Игоревна", 19, "Ж", 1, 4.8));
            group.addStudent(new Student("Павел", "Горохов", "Олегович", 23, "М", 3, 5));

        } catch (NotCorrectAgeException e) {
            System.out.println("Ошибка создания студента: " + e.getMessage());
        }

        group.removeStudent(1);
        group.printStudents();

        Student s = group.getStudent(0);
        if (s != null) {
            System.out.println("Найден студент: " + s);
        }
    }
}