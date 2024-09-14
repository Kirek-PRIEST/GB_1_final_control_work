package animals.animalsActions.operations;

import animals.ListOfAnimals;
import animals.animalsActions.AnimalsController;
import types.ListOfTypes;

public class SortingAnimalsByDate implements AnimalsOperations{
    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        AnimalsController controller = new AnimalsController();
        controller.sortAnimalsByDate(list);
        return null;
    }
}
