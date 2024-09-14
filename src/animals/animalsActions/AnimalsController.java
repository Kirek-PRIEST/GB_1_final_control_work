package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import animals.animalsCommandsActions.AddCommand;
import animals.animalsCommandsActions.ChangeCommands;
import types.ListOfTypes;

import java.util.Scanner;

public class AnimalsController {


    public ListOfAnimals addAnimal(ListOfAnimals animalsList, ListOfTypes typesList) {
        AddAnimal adding = new AddAnimal();
        return adding.addingAnimal(animalsList, typesList);
    }
    public void toCommandsMenu(ListOfAnimals animals){
        ToCommandsMenu toCommandsMenu = new ToCommandsMenu();
        toCommandsMenu.toCommandsMenu(animals);
    }

    public void printAnimals(ListOfAnimals list) {
        System.out.println("Список животных:\n" +
                "id\tИмя\t\tпол\tдата рождения\tсписок команд\n ===");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getAnimal(i));
        }
    }


    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    private Animal printAnimal(ListOfAnimals list, int id) {
        return list.getAnimal(id - 1);
    }
}
