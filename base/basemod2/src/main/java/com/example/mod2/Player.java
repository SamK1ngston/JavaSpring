package com.example.mod2;
import java.util.Random;
//Перечисление для установки выбора
enum VARIANTS {
    ROCK,
    PAPER,
    SCISSORS
}
class Player {
    private VARIANTS choice;
    private String name;
    //первый конструктор
    public Player() {
        Random random = new Random();
        this.choice = VARIANTS.values()[random.nextInt(VARIANTS.values().length)];
        this.name = "Bot";
    }
    //второй конструктор
    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }
    //Эти методы позволяют получить выбор и имя игрока
    public VARIANTS getChoice() {
        return choice;
    }
    public String getName() {
        return name;
    }
    //функция whoWins, которая принимает два объекта и возвращает либо строку «Ничья», либо информацию про игрока, который победил.
    public String whoWins(Player opponent) {
        if (this.choice == opponent.choice) {
            return "Ничья";
        } else if ((this.choice == VARIANTS.ROCK && opponent.choice == VARIANTS.SCISSORS) ||
                (this.choice == VARIANTS.PAPER && opponent.choice == VARIANTS.ROCK) ||
                (this.choice == VARIANTS.SCISSORS && opponent.choice == VARIANTS.PAPER)) {
            return "Победил игрок с именем: " + this.name;
        } else if ((this.choice == VARIANTS.SCISSORS && opponent.choice == VARIANTS.ROCK) ||
                (this.choice == VARIANTS.ROCK && opponent.choice == VARIANTS.PAPER) ||
                (this.choice == VARIANTS.PAPER && opponent.choice == VARIANTS.SCISSORS)) {
            return "Победил игрок с именем: " + opponent.name;
        }
        return null;
    }
}
