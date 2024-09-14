package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import animals.utils.InputDate;
import types.ListOfTypes;

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
            } else {
                typeOfAnimal = types.getType(index);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Выбран неверный вид животного, повторите ввод!");
            type(types);
        }
        return typeOfAnimal;

    } // Ввод вида животного

    private Date birthday() {
        InputDate inputDate = new InputDate();
        return inputDate.input();
    } // Ввод даты рождения животного

    private ArrayList<String> commands() {

        String input = prompt("Введите спсок команд через запятую: ");
        ArrayList<String> newCommands = new ArrayList<>(Arrays.asList(input.split(",")));
        for (int i = 0; i < newCommands.size() - 1; i++) {
            newCommands.set(i, newCommands.get(i).startsWith(" ") ? newCommands.get(i).substring(1) : newCommands.get(i));
        }
        return newCommands;
    } // Ввод коман, которые выполняет животное


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
