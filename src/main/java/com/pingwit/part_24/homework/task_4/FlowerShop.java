package com.pingwit.part_24.homework.task_4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FlowerShop {
    private static final List<String> FLOWERS = Arrays.asList("Ромашки", "Розы", "Тюльпаны");

    private void displayFlowers() {
        for (int i = 0; i < FLOWERS.size(); i++) {
            System.out.println((i + 1) + ". " + FLOWERS.get(i));
        }
    }

    /* у тебя был приватный метод isEligibleForDiscount, мой прошлый комментарий был про него.
     в методе processOrder у тебя есть неиспользуемые переменные selectedFlower, address - это косяк, но я предлагаю на данный момент оставить эту задачу и двигаться дальше.
     Можем к ней вернуться через какое-то время и поймешь как лучше зарефакторить код
     */
    public void processOrder(Scanner scanner) {
        String selectedFlower = selectFlower(scanner);

        LocalDate birthday = promptForBirthday(scanner);

        checkForDiscount(birthday);

        String address = promptForAddress(scanner);

        System.out.println("Благодарим за ваш заказ, курьер свяжется с вами в ближайшее время.");
    }

    private String selectFlower(Scanner scanner) {
        String selectedFlower = null;
        boolean isFirstAttempt = true;

        while (selectedFlower == null) {
            try {
                if (isFirstAttempt) {
                    System.out.println("Добрый день, у нас самые свежие цветы, выберите номер позиции и нажмите Enter:");
                    isFirstAttempt = false;
                } else {
                    System.out.println("Пожалуйста, выберите номер позиции еще раз и нажмите Enter:");
                }

                displayFlowers();

                System.out.println("Ваш выбор: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice < 1 || choice > FLOWERS.size()) {
                    throw new IndexOutOfBoundsException("Ошибка: Вы выбрали несуществующую позицию.");
                } else {
                    selectedFlower = FLOWERS.get(choice - 1);
                    System.out.println("Вы выбрали: " + selectedFlower);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный ввод. Пожалуйста, введите номер позиции.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        return selectedFlower;
    }

    private LocalDate promptForBirthday(Scanner scanner) {
        LocalDate birthday = null;

        while (birthday == null) {
            System.out.print("Введите вашу дату рождения (в формате ГГГГ-ММ-ДД): ");
            try {
                birthday = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Ошибка: некорректная дата. Попробуйте снова.");
            }
        }
        return birthday;
    }

    private void checkForDiscount(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.getMonthValue() == 3 && currentDate.getDayOfMonth() == 8) {
            System.out.println("В честь праздника 8 Марта мы дарим вам скидку 10% на весь заказ.");
        } else if (currentDate.getMonthValue() == birthday.getMonthValue() && currentDate.getDayOfMonth() == birthday.getDayOfMonth()) {
            System.out.println("В честь вашего дня рождения мы дарим вам скидку 10% на весь заказ.");
        } else {
            System.out.println("Сегодня нет специальных скидок.");
        }
    }

    private String promptForAddress(Scanner scanner) {
        String address = null;

        while (address == null || address.trim().isEmpty()) {
            System.out.println("Введите пожалуйста адрес доставки: ");
            address = scanner.nextLine();

            if (address.trim().isEmpty()) {
                System.out.println("Ошибка: Адрес не может быть пустым. Пожалуйста, введите адрес.");
            }
        }
        return address;
    }
}