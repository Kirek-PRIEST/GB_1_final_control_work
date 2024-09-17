package printer.operations;

import animals.ListOfAnimals;
import animals.animalsActions.AnimalsController;
import animals.animalsActions.operations.AnimalsOperations;
import printer.PrinterController;
import types.ListOfTypes;

public class SortingAnimalsByDate implements PrinterOperations {

    @Override
    public void printing(ListOfAnimals pets, ListOfAnimals packAnimals) {
        PrinterController controller = new PrinterController();
        controller.sortAnimalsByDate(pets, packAnimals);
    }
}
