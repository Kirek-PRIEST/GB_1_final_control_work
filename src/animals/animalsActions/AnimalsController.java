package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import printer.MergeByDate;
import printer.SortAnimalsByDateSimple;
import utils.PrintAnimalsList;
import types.ListOfTypes;

import java.util.Scanner;

public class AnimalsController {


    public void addAnimal(ListOfAnimals animalsList, ListOfAnimals packAnimals, ListOfTypes typesList) {
        AddAnimal adding = new AddAnimal();
        adding.addingAnimal(animalsList, packAnimals , typesList);
    }
    public void toCommandsMenu(ListOfAnimals animals){
        ToCommandsMenu toCommandsMenu = new ToCommandsMenu();
        toCommandsMenu.toCommandsMenu(animals);
    }
    public void toPrinterMenu(ListOfAnimals pets, ListOfAnimals packAnimals){
        ToPrinterMenu toPrinterMenu = new ToPrinterMenu();
        toPrinterMenu.toPrinterMenu(pets, packAnimals);
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
