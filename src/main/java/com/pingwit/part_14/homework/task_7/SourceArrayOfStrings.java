package com.pingwit.part_14.homework.task_7;

public class SourceArrayOfStrings {
    public static void main(String[] args) {
        String[] strings = {"Ford", "Fiat", "Volvo", "Tesla", "Toyota", "Lamborghini", "Volkswagen"};
        System.out.println("Строки длиной больше 5 символов:");

        int hieroglyph = 5;

        for (String str : strings) {
            if (str.length() > hieroglyph) {
                System.out.println(str);
            }
        }
    }
}