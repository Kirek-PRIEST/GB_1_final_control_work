package animals.animalsCommandsActions;

import animals.ListOfAnimals;
import animals.animalsActions.Menus;

import java.util.HashMap;
import java.util.Scanner;

public class CommandsMenu {
    private boolean isExit = false;
    HashMap<Integer, CommandsOperations> map = Menus.commandsCommands();

    public void menu(ListOfAnimals animalsList) {
        try {
            while (true) {
                while (!isExit) {
                    int choice = Integer.parseInt(prompt("Список доступных действий:\n" +
                            "1 = добавить команду\n" +
                            "2 = изменить команду\n" +
                            "3 = удалить команду"
                    ));
                    if (choice > 0 && choice <= map.size()) {
                        CommandsOperations operations = map.get(choice);
                        operations.changing(animalsList);
                    } else {
                        System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
                        menu(animalsList);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
            menu(animalsList);
        }

    }

    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
