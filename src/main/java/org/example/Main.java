package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        List<String> list = new ArrayList<>(Arrays.asList("кот", "собака", "да", "кот", "бобр", "собака"));

        System.out.println("Наиболее часто встречающееся и самое короткое слово: " +
                list.stream()
                        .collect(groupingBy(Function.identity(), counting()))
                        .entrySet().stream()
                        .filter(entry -> Objects.equals(entry.getValue(), Collections.max(
                                list.stream().collect(groupingBy(Function.identity(), counting())).values()
                        ))) // Выбор наиболее часто встречающегося слова
                        .map(Map.Entry::getKey)
                        .min(Comparator.comparing(String::length)) // Выбор самого короткого слова, если их несколько
                        .orElse("Нет повторяющихся слов")
        );


        System.out.println("-------------");
        System.out.println("2 Задание");
        System.out.println(" ");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ванек", "Баллиста", 1, 4.75),
                new Student("Санек", "Кочегар", 3, 4.5),
                new Student("Уважаемый", "Слушатель", 2, 5),
                new Student("Улумбек", "Бабаев", 3, 4),
                new Student("Уругвамба", "Да", 5, 3)

        ));
        int N = 3; // Количество искомых сотрудников

        System.out.println(students.stream()
                .sorted(Comparator.comparing(Student::getPoint).reversed())
                .limit(N)
                .sorted(Comparator.comparing(Student::getCourse))
                .map(Student::getSurname)
                .collect(Collectors.joining(", ", N + " самых успешных студентов зовут: ", ";")));
    }
}