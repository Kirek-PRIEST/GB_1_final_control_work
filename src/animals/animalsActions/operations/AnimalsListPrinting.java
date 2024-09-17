package animals.animalsActions.operations;

import animals.ListOfAnimals;
import printer.PrinterController;
import types.ListOfTypes;

public class AnimalsListPrinting implements AnimalsOperations {
    @Override
    public void animalsOperations(ListOfAnimals pets, ListOfAnimals packAnimals, ListOfTypes listOfTypes) {
        PrinterController controller = new PrinterController();
        controller.printAllAnimals(pets, packAnimals);

    }
}
