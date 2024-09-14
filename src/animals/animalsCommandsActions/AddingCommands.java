package animals.animalsCommandsActions;

import animals.Animal;
import animals.ListOfAnimals;
import animals.animalsActions.AnimalsController;

public class AddingCommands implements CommandsOperations{

    @Override
    public Animal changing(ListOfAnimals list) {
        CommandsController controller = new CommandsController();
        controller.addCommand(list);
        return null;

    }
}
