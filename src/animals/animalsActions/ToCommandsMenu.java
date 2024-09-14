package animals.animalsActions;

import animals.ListOfAnimals;
import animals.animalsCommandsActions.CommandsMenu;

public class ToCommandsMenu {
    public void toCommandsMenu(ListOfAnimals animalsList) {
        CommandsMenu commandsMenu = new CommandsMenu();
        commandsMenu.menu(animalsList);
    }
}
