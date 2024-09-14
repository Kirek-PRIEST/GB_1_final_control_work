package animals.animalsCommandsActions;

import animals.Animal;
import animals.ListOfAnimals;

public class CgangingCommands implements CommandsOperations {
    @Override
    public Animal changing(ListOfAnimals list) {
        CommandsController controller = new CommandsController();
        controller.changeCommand(list);
        return null;
    }

}
