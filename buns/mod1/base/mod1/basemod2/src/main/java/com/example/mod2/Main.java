package com.example.mod2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Player bot = new Player();
        Player alex = new Player(VARIANTS.SCISSORS, "Alex");
        System.out.println(bot.whoWins(alex));
    }
}
