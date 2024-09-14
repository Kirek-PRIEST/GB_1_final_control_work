package animals.utils;

import animals.ListOfAnimals;

public class PrintAnimalsList {
    public void print(ListOfAnimals list){
        System.out.println("Список животных:\n" +
                "id\tИмя\t\tпол\tдата рождения\tсписок команд\n");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getAnimal(i));
        }
        System.out.println("===");
    }
}
