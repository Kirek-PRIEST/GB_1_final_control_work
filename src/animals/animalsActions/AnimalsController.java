package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import animals.utils.PrintAnimalsList;
import types.ListOfTypes;

import java.util.Scanner;

public class AnimalsController {


    public ListOfAnimals addAnimal(ListOfAnimals animalsList, ListOfTypes typesList) {
        AddAnimal adding = new AddAnimal();
        return adding.addingAnimal(animalsList, typesList);
    }
    public void toCommandsMenu(ListOfAnimals animals){
        ToCommandsMenu toCommandsMenu = new ToCommandsMenu();
        toCommandsMenu.toCommandsMenu(animals);
    }

    public void printAnimals(ListOfAnimals list) {
        printList(list);
    }
    public void sortAnimalsByDate(ListOfAnimals list){
        SortAnimalsByDateSimple sort = new SortAnimalsByDateSimple();
        sort.SortAnimals(list);
    }
    public void mergeAnimalsByDate(ListOfAnimals list){
        MergeByDate merge = new MergeByDate();
        printList(merge.merge(list));
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    private Animal printAnimal(ListOfAnimals list, int id) {
        return list.getAnimal(id - 1);
    }
    private void printList(ListOfAnimals list){
        PrintAnimalsList print = new PrintAnimalsList();
        print.print(list);
    }
}
