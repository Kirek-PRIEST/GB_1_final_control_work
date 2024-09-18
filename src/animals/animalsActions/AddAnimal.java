package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import types.TypeOfAnimal;
import utils.InputDate;
import types.ListOfTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class AddAnimal {

    public void addingAnimal(ListOfAnimals list, ListOfAnimals packAnimals, ListOfTypes types) {
        int id = list.getSize() + 1;
        Animal newAnimal = createAnimal(id, types);
        System.out.println("Вы добавили " + newAnimal.getType().getType() + " животное:\n" + newAnimal + "\n");


        if (newAnimal.getType().getType().equals("вьючное")) {
            packAnimals.addAnimal(newAnimal);
        } else list.addAnimal(newAnimal);
    }

    private Animal createAnimal(int id, ListOfTypes types) {
        String name = promptNotEmpty("Введите имя животного: ");
        char sex = promptSex();
        TypeOfAnimal type = promptType(types);
        Date birthday = promptBirthday();
        ArrayList<String> commands = promptCommands();

        return new Animal(id, name, sex, type, birthday, commands);
    }

    private char promptSex() {
        String input = prompt("Введите пол животного (М/Ж): ").toUpperCase();
        if (input.length() == 1 && (input.charAt(0) == 'М' || input.charAt(0) == 'Ж')) {
            return input.charAt(0);
        }
        System.out.println("Пол животного введён некорректно. Введите М, или Ж");
        return promptSex();
    }

    private TypeOfAnimal promptType(ListOfTypes types) {
        System.out.println("Список доступных видов:");
        System.out.println(types);
        String input = prompt("Выберете вид животного из списка (цифра): ");
        while (!isNumeric(input)) {
            input = prompt("Введено некорректное значение.");
        }
        int index = Integer.parseInt(input) - 1;
        if (index < 0 | index >= types.getSize()) {
            System.out.println("Такого пункта в списке нет.");
            return promptType(types);
        } else {
            return types.getType(index);
        }

    } // Ввод вида животного

    private Date promptBirthday() {
        InputDate inputDate = new InputDate();
        return inputDate.input();
    } // Ввод даты рождения животного

    private ArrayList<String> promptCommands() {
        String input = prompt("Введите список команд через запятую: ");
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private String promptNotEmpty(String message) {
        String input = prompt(message);
        return input.isEmpty() ? promptNotEmpty("Поле не может быть пустым. " + message) : input;
    }

    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
