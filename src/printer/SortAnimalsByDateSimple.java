package printer;

import animals.Animal;
import animals.ListOfAnimals;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortAnimalsByDateSimple {
    public ListOfAnimals SortAnimals(ListOfAnimals pets, ListOfAnimals packAnimals, int choice) {
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
        map.put(1, sortByDate(pets));
        map.put(2, sortByDate(packAnimals));
        map.put(3, sortByDate(merged));
        return map.get(choice);
    }

    private ListOfAnimals sortByDate(ListOfAnimals list) {
        Collections.sort(list.getList(), new Comparator<Animal>() {
            @Override
            public int compare(Animal p1, Animal p2) {
                return p1.getBirthdayDate().compareTo(p2.getBirthdayDate());
            }
        });
        return list;
    }
}
