package animals.animalsActions;

import animals.EndProgram;
import animals.animalsActions.operations.*;
import animals.animalsCommandsActions.operations.AddingCommands;
import animals.animalsCommandsActions.operations.CgangingCommands;
import animals.animalsCommandsActions.operations.CommandsOperations;
import printer.operations.PrinterOperations;
import printer.operations.MergingByDate;
import printer.operations.PrintingAnimals;
import printer.operations.SortingAnimalsByDate;

import java.util.HashMap;

public class Menus {

    public static HashMap<Integer, AnimalsOperations> animalsCommands() {
        HashMap<Integer, AnimalsOperations> map = new HashMap<>();
        map.put(1, new AddingAnimal());
        map.put(2, new GoingToCommandsMenu());
        map.put(3, new GoingToPrinterMenu());
        map.put(4, new EndProgram());
        return map;
    }

    public static HashMap<Integer, CommandsOperations> commandsCommands() {
        HashMap<Integer, CommandsOperations> map = new HashMap<>();
        map.put(1, new AddingCommands());
        map.put(2, new CgangingCommands());
        return map;
    }

    public static HashMap<Integer, PrinterOperations> printerCommands() {
        HashMap<Integer, PrinterOperations> map = new HashMap<>();
        map.put(1, new PrintingAnimals());
        map.put(2, new SortingAnimalsByDate());
        map.put(3, new MergingByDate());
        return map;
    }
}
