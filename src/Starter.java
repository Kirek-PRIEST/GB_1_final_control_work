import animals.ListOfAnimals;
import animals.animalsActions.operations.AnimalsOperations;
import animals.animalsActions.Menus;
import types.ListOfTypes;

import java.util.HashMap;
import java.util.Scanner;

public class Starter {
    private boolean isExit = false;
    HashMap<Integer, AnimalsOperations> map = Menus.animalsCommands();
    ListOfTypes typesList = new ListOfTypes();
    ListOfAnimals petsList = new ListOfAnimals();
    ListOfAnimals packAnimalsList = new ListOfAnimals();


    public void run() {
        Start(typesList);
        try {

                while (!isExit) {
                    System.out.println(String.format("Всего животных в реестре: %s. (домашних  - %s, вьючых - %s)",
                            (petsList.getSize() + packAnimalsList.getSize()), petsList.getSize(), packAnimalsList.getSize()

                    ));
                    int choice = Integer.parseInt(prompt("Список доступных действий:\n" +
                            "1 = добавить животное\n" +
                            "2 = изменить список команд животного\n" +
                            "3 = печать списков\n" +
                            "4 = выйти из программы\n" +
                            "==>"

                    ));
                    if (choice > 0 && choice <= map.size()) {
                        AnimalsOperations operations = map.get(choice);
                        operations.animalsOperations(petsList, packAnimalsList, typesList);
                    } else {
                        System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
                        run();
                    }

            }
        } catch (NumberFormatException e) {
            System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
            run();
        }

    }


    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    /* код для ускорения начала работы с программой - создаёт список видов животныхЮ чтобы не создавать его вручную*/
    private ListOfTypes Start(ListOfTypes list) {
        list.addType("Кошка", "домашнее");
        list.addType("Капибара", "домашнее");
        list.addType("Верблюд", "вьючное");
        list.addType("Собака", "домашнее");
        list.addType("Хомяк", "домашнее");
        list.addType("Лошадь", "вьючное");
        list.addType("Осёл", "вьючное");
        return list;
    }
}

