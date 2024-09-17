package printer;

import animals.ListOfAnimals;
import animals.animalsActions.Menus;
import printer.operations.PrinterOperations;

import java.util.HashMap;
import java.util.Scanner;

public class PrinterMenu {
    private boolean isExit = false;
    HashMap<Integer, PrinterOperations> map = Menus.printerCommands();

    public void menu(ListOfAnimals pets, ListOfAnimals packAnimals) {
        try {
            while (true) {
                while (!isExit) {
                    int choice = Integer.parseInt(prompt("Список доступных действий:\n" +
                                    "1 = вывести список животных\n" +
                                    "2 = сортировать список животных по дате рождения\n" +
                                    "3 = поиск животных по дате рождения\n" +
                                    "4 = в предыдущее меню"
                    ));
                    if (choice == 4){
                        return;
                    }else if (choice > 0 && choice <= map.size()) {
                        PrinterOperations operations = map.get(choice);
                        operations.printing(pets, packAnimals);
                    } else {
                        System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
                        menu(pets, packAnimals);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
            menu(pets,packAnimals);
        }

    }

    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
