package printer.operations;

import animals.ListOfAnimals;
import printer.PrinterController;

public class SortingAnimalsByDate implements PrinterOperations {

    @Override
    public void printing(ListOfAnimals pets, ListOfAnimals packAnimals) {
        PrinterController controller = new PrinterController();
        controller.sortAnimalsByDate(pets, packAnimals);
    }
}
