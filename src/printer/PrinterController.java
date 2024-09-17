package printer;

import animals.ListOfAnimals;
import utils.PrintAnimalsList;

import java.util.Scanner;

public class PrinterController {

    public void printAllAnimals(ListOfAnimals pets, ListOfAnimals packAnimals) {
        PrintAllAnimals toPrint = new PrintAllAnimals();
        int choice = choice();
        PrintAnimalsList print = new PrintAnimalsList();

        print.print(toPrint.toPrint(pets, packAnimals, choice));
    }
    public void sortAnimalsByDate(ListOfAnimals pets, ListOfAnimals packAnimals){
        SortAnimalsByDateSimple sort = new SortAnimalsByDateSimple();
        int choice = choice();
        PrintAnimalsList print = new PrintAnimalsList();

        print.print(sort.SortAnimals(pets, packAnimals, choice));
    }
    public void mergeAnimalsByDate(ListOfAnimals pets, ListOfAnimals packAnimals){
        MergeByDate merge = new MergeByDate();
        PrintAnimalsList print = new PrintAnimalsList();
        int choice = choice();

        print.print(merge.merge(pets, packAnimals, choice));
    }


    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private int choice(){
        String input = prompt("""
                1 = домашние животные
                2 = вьючные животные
                3 = все животные
                """);
        while (!isNumeric(input)){
            System.out.println("Введены неверные данные. Выберите один из предложеных пунктов:");
            return choice();
        }
        int choice = Integer.parseInt(input);
        if (choice < 1 || choice >3){
            System.out.println("Введены неверные данные. Выберите один из предложеных пунктов:");
            return choice();
        }
        return Integer.parseInt(input);
    }
}
