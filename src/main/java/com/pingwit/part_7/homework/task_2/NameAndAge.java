package com.pingwit.part_7.homework.task_2;

public class NameAndAge { // -> Person, Student, Dog... Не используй названия вроде NameAndAge

    String name;
    int age;

    public NameAndAge(String name, int age) {
        System.out.println("Constructor:");
        this.name = name;
        this.age = age;
    }

    public NameAndAge() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Блок инициализации
    {
        System.out.println("Создан новый экземпляр класса NameAndAge");
    }

}
