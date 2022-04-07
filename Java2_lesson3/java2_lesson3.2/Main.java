package ru.geekbrains.com;


public class Main {
    public static void main(String[] args){
        System.out.println("Создаем справочник");
        Phonebook phonebook = new Phonebook();
        System.out.println("-----------------");

        System.out.println("Наполняем справочник");
        phonebook.add("Иванов", "11223344");
        phonebook.add("Иванов", "22334455");
        phonebook.add("Петров", "22334466");
        phonebook.add("Сидоров", "22334477");
        phonebook.add("Иванов", "22334488");
        System.out.println("-----------------");

        System.out.println("Получаем номера");
        System.out.println("Иванов");
        System.out.println(phonebook.get("Иванов"));
        System.out.println("Петров");
        System.out.println(phonebook.get("Петров"));
        System.out.println("Сидоров");
        System.out.println(phonebook.get("Сидоров"));
        System.out.println("-----------------");

        System.out.println("Случай отсутствия записи");
        System.out.println("Кузнецов");
        System.out.println(phonebook.get("Кузнецов"));
        System.out.println("-----------------");

        System.out.println("Пробуем записать существующий номер");
        phonebook.add("Иванов", "11223344");
        System.out.println("Иванов");
        System.out.println(phonebook.get("Иванов"));
    }
}


