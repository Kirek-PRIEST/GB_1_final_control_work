package animals.animalsActions;

import animals.ListOfAnimals;
import types.ListOfTypes;

public class AnimalsListPrinting implements AnimalsOperations{
    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        AnimalsController controller = new AnimalsController();
        controller.printAnimals(list);
        return list;
    }
}
