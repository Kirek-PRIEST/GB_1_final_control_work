package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import types.ListOfTypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class AddAnimal {

    public ListOfAnimals addingAnimal(ListOfAnimals list, ListOfTypes types) {
        int id = list.getSize() + 1;
        Animal newAnimal = new Animal(id,
                prompt("Введите имя животного: "),
                sex(),
                type(types),
                birthday(),
                commands()
        );
        System.out.println("Вы добавили животное:\n" +
                            newAnimal
                );
        list.addAnimal(newAnimal);
        return list;
    }


    private Character sex() {
        String input = prompt("Введите пол животного (М/Ж): ").toUpperCase();
        if (input.length() > 1) {
            System.out.println("Пол животного введён некорректно. Введите М, или Ж");
            sex();
        } else if (input.charAt(0) != 'М' && input.charAt(0) != 'Ж') {
            System.out.println("Пол животного введён некорректно. Введите М, или Ж");
            sex();
        }
        return input.charAt(0);
    } // Ввод пола животного

    private String type(ListOfTypes types) {
        int index = 0;
        String typeOfAnimal = null;
        try {
            System.out.println("Список доступных видов:");
            System.out.println(types);
            String input = prompt("Выберете вид животного (цифра): ");
            while (!isNumeric(input)) {
                input = prompt("Введено некорректное значение.");
            }
            index = Integer.parseInt(input) - 1;
            if (index < 0 || index > types.getSize()) {
                type(types);
            }else {
            typeOfAnimal = types.getType(index);}

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Выбран неверный вид животного, повторите ввод!");
            type(types);
        }
        return typeOfAnimal;

    } // Ввод вида животного

    private Date birthday() {
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

    } // Ввод даты рождения животного
    private ArrayList<String> commands() {

        String input = prompt("Введите спсок команд через запятую: ");
        ArrayList<String> newCommands = new ArrayList<>(Arrays.asList(input.split(",")));
        for (int i = 0; i < newCommands.size() - 1; i++) {
            newCommands.set(i, newCommands.get(i).startsWith(" ") ? newCommands.get(i).substring(1) : newCommands.get(i));
        }
        return newCommands;
    } // Ввод коман, которые выполняет животное
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



    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
