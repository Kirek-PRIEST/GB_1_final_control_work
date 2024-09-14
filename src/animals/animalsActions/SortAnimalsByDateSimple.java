package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

public class SortAnimalsByDateSimple {
    public void SortAnimals(ListOfAnimals list) {

        Collections.sort(list.getList(), new Comparator<Animal>() {
            @Override
            public int compare(Animal p1, Animal p2) {
                return p1.getBirthdayDate().compareTo(p2.getBirthdayDate());
            }
        });
        System.out.println("Список животных:\n" +
                "id\tИмя\t\tпол\tдата рождения\tсписок команд\n ===");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getAnimal(i));
        }
        System.out.println("\n");
    }
}
