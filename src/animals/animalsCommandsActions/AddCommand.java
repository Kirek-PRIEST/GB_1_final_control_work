package animals.animalsCommandsActions;

import animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddCommand {
    public void newCommands(Animal animal){
        String input = prompt("Введите спсок команд через запятую: ");
        ArrayList<String> commands = new ArrayList<>(Arrays.asList(input.split(",")));
        for (int i = 0; i < commands.size() - 1; i++) {
            commands.set(i, commands.get(i).startsWith(" ") ? commands.get(i).substring(1) : commands.get(i));
        }
        for (String command : commands) {
            ArrayList<String> b = animal.getCommands();
            b.add(command);
            animal.setCommands(b);
        }
    }
    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
