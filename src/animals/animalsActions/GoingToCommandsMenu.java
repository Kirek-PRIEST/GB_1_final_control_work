package animals.animalsActions;

import animals.ListOfAnimals;
import types.ListOfTypes;

import java.awt.*;

public class GoingToCommandsMenu implements AnimalsOperations{
    @Override
    public ListOfAnimals animalsOperations(ListOfAnimals list, ListOfTypes typesList) {
        AnimalsController controller = new AnimalsController();
        controller.toCommandsMenu(list);
        return null;
    }
}
