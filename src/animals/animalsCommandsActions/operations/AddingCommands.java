package animals.animalsCommandsActions.operations;

import animals.Animal;
import animals.ListOfAnimals;
import animals.animalsCommandsActions.CommandsController;

public class AddingCommands implements CommandsOperations {

    @Override
    public Animal changing(ListOfAnimals list) {
        CommandsController controller = new CommandsController();
        controller.addCommand(list);
        return null;

    }
}
