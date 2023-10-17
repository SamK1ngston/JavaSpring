package com.example.mod3;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "userdata.ser";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос данных пользователя
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Считываем лишний перевод строки после nextInt

        System.out.print("Введите хобби через запятую: ");
        String[] hobbiesArray = scanner.nextLine().split(",");
        List<String> hobbies = new ArrayList<>();
        // Добавление хобби в список
        for (String hobby : hobbiesArray) {
            hobbies.add(hobby.trim());
        }
        // Создание объекта UserData с введенными данными
        UserData userData = new UserData(name, login, age, hobbies);

        // Сериализация объекта
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(userData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            UserData deserializedUserData = (UserData) ois.readObject();
            System.out.println(deserializedUserData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
