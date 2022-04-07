package ru.geekbrains.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phonebook {

    public HashMap<String, List<String>> book;

    public Phonebook(){
        this.book = new HashMap<>();
    }

    public void add(String surname, String number){
        if(book.containsKey(surname)){
            List<String> numbers = book.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.printf("Номер %s добавлен для фамилии %s%n", number, surname);
            } else {
                System.out.printf("Номер %s уже существует для фамилии %s%n", number, surname);
            }
        } else {
            book.put(surname, new ArrayList<>(List.of(number)));
            System.out.printf("Номер %s добавлен для фамилии %s%n", number, surname);
        }
    }

    public List<String> get(String surname){
        if(book.containsKey(surname)){
            return book.get(surname);
        } else {
            System.out.printf("В справочнике нет записи для фамилии %s%n", surname);
            return new ArrayList<>();
        }
    }
}