package com.streams.api4.second;

import students.Gender;
import students.Human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort {
    public static void main(String[] args) {
        Student student1 = new Student("Abigail", "Bbarbux", Gender.FEMALE);
        Student student2 = new Student("Kent", "Rom", Gender.TRANSFORMER);
        Student student3 = new Student("Ivan", "Lovecraft", Gender.MALE);
        Student student4 = new Student("Ron", "Brabus", Gender.FEMALE);
        Student student5 = new Student("Kent", "Rom", Gender.TRANSFORMER);
        Student student6 = new Student("ds", "Rom", Gender.TRANSFORMER);
        Student student7 = new Student("Kent", "Rom", Gender.TRANSFORMER);

        student1.setAge(21);
        student2.setAge(19);
        student3.setAge(17);
        student4.setAge(23);
        student5.setAge(22);
        student6.setAge(20);
        student7.setAge(18);

        List<Student> students = new ArrayList<>(List.of(student1, student2, student3, student4, student5, student6, student7));

        List<Student> newStudents = students.stream()
                .filter(student -> student.getAge() > 20)
                .sorted(Comparator.comparing(Human::getLastName))
                .toList();

        System.out.println(newStudents);
    }
}
