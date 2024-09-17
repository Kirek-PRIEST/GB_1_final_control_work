package animals.animalsCommandsActions.operations;

import animals.Animal;
import animals.ListOfAnimals;
import animals.animalsCommandsActions.CommandsController;
import animals.animalsCommandsActions.operations.CommandsOperations;

public class CgangingCommands implements CommandsOperations {
    @Override
    public Animal changing(ListOfAnimals list) {
        CommandsController controller = new CommandsController();
        controller.changeCommand(list);
        return null;
    }

}
