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
    ListOfAnimals animalsList = new ListOfAnimals();

    public void run() {
        Start(typesList);

        try {
            while (true) {
                while (!isExit) {
                    System.out.println("Всего животных в реестре: " + animalsList.getSize());
                    int choice = Integer.parseInt(prompt("Список доступных действий:\n" +
                            "1 = добавить животное\n" +
                            "2 = изменить список команд животного\n" +
                            "3 = вывести список животных\n" +
                            "4 = сортировать список животных по дате рождения\n" +
                            "5 = поиск животных по дате рождения\n" +
                            "6 = выйти из программы"

                    ));
                    if (choice > 0 && choice <= map.size()) {
                        AnimalsOperations operations = map.get(choice);
                        operations.animalsOperations(animalsList, typesList);
                    } else {
                        System.out.println("Введена некорректная команда. Пожалуйста, повторите ввод.\n");
                        run();
                    }
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
        list.addType("Кошка", "Домашнее");
        list.addType("Капибара", "Домашнее");
        list.addType("Верблюд", "Вьючное");
        list.addType("Собака", "Домашнее");
        list.addType("Хомяк", "Домашнее");
        list.addType("Лошадь", "Вьючное");
        list.addType("Осёл", "Вьючное");
        return list;
    }
}

