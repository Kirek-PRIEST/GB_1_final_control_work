package printer;

import animals.Animal;
import animals.ListOfAnimals;

import java.util.HashMap;

public class PrintAllAnimals {
    public ListOfAnimals toPrint(ListOfAnimals pets, ListOfAnimals packAnimals, int choice){
        HashMap<Integer, ListOfAnimals> map = new HashMap<>();
        ListOfAnimals merged = new ListOfAnimals();
        if (choice == 3) {
            for (Animal a : pets.getList()) {
                merged.addAnimal(a);
            }
            for (Animal a : packAnimals.getList()) {
                merged.addAnimal(a);

            }
        }
        map.put(1, pets);
        map.put(2, packAnimals);
        map.put(3, merged);

        return map.get(choice);
    }
}
