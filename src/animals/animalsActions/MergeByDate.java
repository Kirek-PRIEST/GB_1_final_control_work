package animals.animalsActions;

import animals.Animal;
import animals.ListOfAnimals;
import animals.utils.InputDate;
import animals.utils.PrintAnimalsList;

import java.util.Date;

public class MergeByDate {
    public ListOfAnimals merge(ListOfAnimals list) {
        InputDate inputDate = new InputDate();
        Date input = inputDate.input();
        ListOfAnimals merged = new ListOfAnimals();
        for (Animal a : list.getList()) {
            if (a.getBirthdayDate().compareTo(input) == 0) {
                merged.addAnimal(a);
            }
        }
        return merged;
    }
}

