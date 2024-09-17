package printer.operations;

import animals.ListOfAnimals;
import printer.PrinterController;

public class PrintingAnimals implements PrinterOperations{
    @Override
    public void printing(ListOfAnimals pets, ListOfAnimals packAnimals) {
        PrinterController controller = new PrinterController();
        controller.printAllAnimals(pets, packAnimals);
    }
}
