package animals.utils;

import animals.ListOfAnimals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;

public class InputDate {
    public Date input(){
        String year = prompt("Введите год рождения животного: ");
        while (!year(year)) {
            year = prompt("Введите год рождения животного: ");
        }
        String month = prompt("Введите месяц рождения животного (1 - 12):");
        while (!month(month)) {
            month = prompt("Введите месяц рождения животного (1 - 12):");
        }
        String day = prompt("Введите день рождения животного");
        while (!day(year, month, day)) {
            day = prompt("Введите день рождения животного");
        }

        if (Integer.parseInt(month) < 10) {
            return stringToDate(day + "/0" + month + "/" + year);
        } else return stringToDate(day + "/" + month + "/" + year);


    }
    private boolean year(String year) {
        try {
            int integerYear = Integer.parseInt(year);
            if (Year.now().getValue() - integerYear > 250 || integerYear > Year.now().getValue()) {
                System.out.println("Введён неверный год рождения животного.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно введён год рождения животного.");
            return false;
        }
        return true;
    } //проверка правильности введённого года

    private boolean month(String month) {
        try {
            int integerMonth = Integer.parseInt(month);
            if (integerMonth < 1 || integerMonth > 12) {
                System.out.println("Неверно введён месяц рождения живртного.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно введён месяц рождения животного.");
            return false;
        }
        return true;
    } // проверка правильности введённого месяца

    private boolean day(String year, String month, String day) {
        try {
            int integerDay = Integer.parseInt(day);
            int integerMonth = Integer.parseInt(month);
            int integerYear = Integer.parseInt(year);
            if (integerMonth != 1 && integerMonth != 3 && integerMonth != 5 && integerMonth != 7 && integerMonth != 8 && integerMonth != 10 && integerMonth != 12) {
                if (integerMonth == 2) {
                    if ((integerYear % 4 == 0 && integerYear % 100 != 0) || (integerYear % 400 == 0)) {
                        if (integerDay > 29 || integerDay < 1) {
                            System.out.println("Неверно введён День рождения живртного. (" + year + " високосный. Введите день рождения животного (число от 1 до 29)");
                            return false;
                        }
                    } else {
                        if (integerDay < 1 || integerDay > 28) {
                            System.out.println("Неверно введён День рождения живртного. (" + year + " не високосный. Введите день рождения животного (число от 1 до 28)");
                            return false;
                        }
                    }
                } else {
                    if (integerDay > 30) {
                        System.out.println("Неверно введён День рождения живртного. В " + integerMonth + "-ом месяце 30 дней");
                        return false;
                    }
                }
            } else {
                if (integerDay < 1 || integerDay > 31) {
                    System.out.println("Неверно введён День рождения живртного.");
                    return false;

                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно введён месяц рождения животного.");
            return false;
        }
        return true;
    } // проверка правильности введённого дня
    private Date stringToDate(String s){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate;
        try {
            startDate = df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return startDate;
    }
    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
