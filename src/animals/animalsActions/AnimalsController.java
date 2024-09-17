package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
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
}
