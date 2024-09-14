package animals.animalsActions.operations;

import animals.ListOfAnimals;
import animals.animalsActions.AnimalsController;
import animals.animalsActions.operations.AnimalsOperations;
import types.ListOfTypes;

public class AddingAnimal implements AnimalsOperations {


    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        AnimalsController controller = new AnimalsController();
        return controller.addAnimal(list, typesList);
    }
}
