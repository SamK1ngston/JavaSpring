package com.example.mod3;
import java.io.Serializable;
import java.util.List;

class UserData implements Serializable {
    public String name, login;
    public int age;
    public List<String> hobbies;

    // Конструктор для инициализации полей
    public UserData(String name, String login, int age, List<String> hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Пользователь: " + name + " с логином " + login + ". Его возраст " + age + " . Все увлечения: " + hobbies;
    }
}
