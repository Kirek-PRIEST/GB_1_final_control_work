package animals.animalsActions;

import animals.ListOfAnimals;
import types.ListOfTypes;

public class AddingAnimal implements AnimalsOperations {


    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        AnimalsController controller = new AnimalsController();
        return controller.addAnimal(list, typesList);
    }
}
