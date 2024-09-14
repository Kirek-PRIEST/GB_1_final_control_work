package animals;

import animals.animalsActions.operations.AnimalsOperations;
import types.ListOfTypes;

public class EndProgram implements AnimalsOperations {
    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        System.out.println("Спасибо за использование программы");
        System.exit(0);
        return null;
    }
}
