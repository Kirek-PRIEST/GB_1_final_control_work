package animals.animalsActions.operations;

import animals.ListOfAnimals;
import animals.animalsActions.AnimalsController;
import types.ListOfTypes;

public class MergingByDate implements AnimalsOperations{
    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        AnimalsController controller = new AnimalsController();
        controller.mergeAnimalsByDate(list);
        return null;
    }
}
