public class Controller {


    public ListOfAnimals addAnimal(ListOfAnimals animalsList, ListOfTypes typesList) {
        AddAnimal adding = new AddAnimal();
        return adding.addingToy(animalsList, typesList);
    }

}
