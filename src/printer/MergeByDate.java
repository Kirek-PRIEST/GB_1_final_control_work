package printer;

import animals.Animal;
import animals.ListOfAnimals;
import utils.InputDate;

import java.util.Date;
import java.util.HashMap;

public class MergeByDate {

    public ListOfAnimals merge(ListOfAnimals pets, ListOfAnimals packAnimals, int choice) {
        HashMap<Integer, ListOfAnimals> map = new HashMap<>();
        ListOfAnimals merged = new ListOfAnimals();
        InputDate inputDate = new InputDate();
        Date bDate = inputDate.input();
        if (choice == 3) {
            for (Animal a : pets.getList()) {
                merged.addAnimal(a);
            }
            for (Animal a : packAnimals.getList()) {
                merged.addAnimal(a);
            }
        }
        map.put(1, mergeByDate(pets, bDate));
        map.put(2, mergeByDate(packAnimals, bDate));
        map.put(3, mergeByDate(merged, bDate));

        return map.get(choice);
    }

    private ListOfAnimals mergeByDate(ListOfAnimals list, Date date) {
        ListOfAnimals merged = new ListOfAnimals();

        for (Animal a : list.getList()) {
            if (a.getBirthdayDate().compareTo(date) == 0) {
                merged.addAnimal(a);
            }
        }
        return merged;
    }

}

