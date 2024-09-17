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
        Animal newAnimal = new Animal(id,
                name(),
                sex(),
                type(types),
                birthday(),
                commands()
        );
        System.out.println("Вы добавили " + newAnimal.getType().getType() + "животное:\n" +
                newAnimal + "\n"
        );

        if (newAnimal.getType().getType().equals("вьючное")) {
            packAnimals.addAnimal(newAnimal);
        } else list.addAnimal(newAnimal);
    }
    private String name(){
        String input = prompt("Введите имя животного: ");
        while (empty(input)){
            System.out.println("Поле не может быть пустым");
            return name();
        }
        return input;
    }


    private Character sex() {
        String input = prompt("Введите пол животного (М/Ж): ").toUpperCase();

        if (input.length() > 1) {
            System.out.println("Пол животного введён некорректно. Введите М, или Ж");
            return sex();
        } else if (input.charAt(0) != 'М' && input.charAt(0) != 'Ж') {
            System.out.println("Пол животного введён некорректно. Введите М, или Ж");
            return sex();
        }else {
            return input.charAt(0);
        }
    } // Ввод пола животного

    private TypeOfAnimal type(ListOfTypes types) {
        System.out.println("Список доступных видов:");
        System.out.println(types);
        String input = prompt("Выберете вид животного из списка (цифра): ");
        while (!isNumeric(input)) {
            input = prompt("Введено некорректное значение.");
        }
        int index = Integer.parseInt(input) - 1;
        if (index < 0 | index > types.getSize()) {
            System.out.println("Такого пункта в списке нет.");
            return type(types);
        } else {
            return types.getType(index);
        }

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

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean empty(String str){
        if (str.equals("")){
            return true;
        }else {
            return false;
        }
    }
}
