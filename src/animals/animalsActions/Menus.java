package animals.animalsActions;

import animals.EndProgram;
import animals.animalsCommandsActions.AddingCommands;
import animals.animalsCommandsActions.CgangingCommands;
import animals.animalsCommandsActions.CommandsOperations;

import java.util.HashMap;

public class Menus {

    public static HashMap<Integer, AnimalsOperations> animalsCommands() {
        HashMap<Integer, AnimalsOperations> map = new HashMap<>();
        map.put(1, new AddingAnimal());
        map.put(2, new GoingToCommandsMenu());
        map.put(3, new AnimalsListPrinting());
        map.put(4, new EndProgram());
        return map;
    }
    public static HashMap<Integer, CommandsOperations> commandsCommands(){
        HashMap<Integer, CommandsOperations> map = new HashMap<>();
        map.put(1, new AddingCommands());
        map.put(2, new CgangingCommands());
        return map;
    }
}
