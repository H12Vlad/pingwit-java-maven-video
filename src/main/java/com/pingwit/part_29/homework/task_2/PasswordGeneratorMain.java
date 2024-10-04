package com.pingwit.part_29.homework.task_2;

import java.util.Scanner;

public class PasswordGeneratorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину пароля: ");
        int length = scanner.nextInt();

        System.out.println("Сгенерированные пароли:");
        for (int i = 0; i < 5; i++) {
            String password = PasswordGenerator.generatePassword(length);
            System.out.println(password);
        }
    }
}