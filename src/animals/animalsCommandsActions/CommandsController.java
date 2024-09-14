package animals.animalsCommandsActions;

import animals.Animal;
import animals.ListOfAnimals;

import java.util.Scanner;

public class CommandsController {
    public void addCommand(ListOfAnimals animals){
        AddCommand command = new AddCommand();
        command.newCommands(selectAnimal(animals));
    } // Добавить комманду животному

    public void changeCommand(ListOfAnimals animalsList) {
        ChangeCommands commands = new ChangeCommands();
        commands.changeCommands(selectAnimal(animalsList));
    }// Изменить все комманды животного (Удаяляет старые, записывает новые)
    private Animal selectAnimal(ListOfAnimals animals){
        System.out.println("Список животных:\n" + animals);
        String input = prompt("Введите id животного у которого хотите изменить команды");
        while (!isNumeric(input) || Integer.parseInt(input) > animals.getSize()){
            System.out.println("Введён некорректный id животного!");
            input = prompt("Введите id животного у которого хотите изменить команды");
        }
        int id = Integer.parseInt(input);
        System.out.println("Вы выбрали животное:\t" +
                printAnimal(animals, id));
        return animals.getAnimal(id);
    }
    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
    private Animal printAnimal(ListOfAnimals list, int id) {
        return list.getAnimal(id - 1);
    }
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
