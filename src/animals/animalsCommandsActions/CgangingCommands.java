package animals.animalsCommandsActions;

import animals.Animal;
import animals.ListOfAnimals;
import animals.animalsActions.AnimalsOperations;
import animals.animalsActions.AnimalsController;
import types.ListOfTypes;

public class CgangingCommands implements CommandsOperations {
    @Override
    public Animal changing(ListOfAnimals list) {
        CommandsController controller = new CommandsController();
        controller.changeCommand(list);
        return null;
    }

}
