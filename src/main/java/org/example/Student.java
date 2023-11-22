package org.example;

public class Student {
    private String name;
    private String surname;
    private int course;
    private double point;

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }

    public int getCourse() { return course; }

    public String getSurname() { return surname; }


    public Student(String name, String surname, int course, double point) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.point = point;
    }
}