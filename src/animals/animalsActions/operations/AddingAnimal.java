package animals.animalsActions.operations;

import animals.ListOfAnimals;
import animals.animalsActions.AnimalsController;
import types.ListOfTypes;

public class AddingAnimal implements AnimalsOperations {


    @Override
    public void animalsOperations(ListOfAnimals pets, ListOfAnimals packAnimals, ListOfTypes listOfTypes) {
        AnimalsController controller = new AnimalsController();
        controller.addAnimal(pets, packAnimals, listOfTypes);
    }
}
