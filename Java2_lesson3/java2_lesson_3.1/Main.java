package ru.geekbrains.com;
//Домашнее задание к уроку Java_2_Lesson_3.
//Ученик Николай Горобий.
//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
// из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Mercedes", "BMW", "Audi", "Toyota", "Volkswagen", "Honda",
                "Opel", "Subaru", "Range Rover", "Lexus", "Toyota", "Volkswagen",
                "BMW", "Audi", "Toyota", "Subaru", "Subaru",
                "Audi", "Toyota", "Subaru", "Subaru", "Toyota", "Honda", "Lexus"
        );

        Set<String> unique = new HashSet<>(words);

        System.out.println("Первоначальный массив");
        System.out.println(words);
        System.out.println("Уникальные слова");
        System.out.println(unique);
        System.out.println("Счетчик повторения слов");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}