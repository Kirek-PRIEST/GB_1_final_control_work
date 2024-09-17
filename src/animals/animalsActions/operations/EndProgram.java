package animals.animalsActions.operations;

import animals.ListOfAnimals;
import animals.animalsActions.operations.AnimalsOperations;
import types.ListOfTypes;

public class EndProgram implements AnimalsOperations {
    @Override
    public void animalsOperations(ListOfAnimals pets, ListOfAnimals typesList, ListOfTypes listOfTypes) {
        System.out.println("Спасибо за использование программы");
        System.exit(0);
    }
}
