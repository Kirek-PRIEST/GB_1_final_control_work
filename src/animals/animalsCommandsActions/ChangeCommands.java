package animals.animalsCommandsActions;

import animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeCommands {
    public void changeCommands(Animal animal){
        String input = prompt("Введите спсок команд через запятую: ");
        ArrayList<String> newCommands = new ArrayList<>(Arrays.asList(input.split(",")));
        for (int i = 0; i < newCommands.size() - 1; i++) {
            newCommands.set(i, newCommands.get(i).startsWith(" ") ? newCommands.get(i).substring(1) : newCommands.get(i));
        }
        animal.setCommands(newCommands);
        System.out.println(animal);

    }
    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
