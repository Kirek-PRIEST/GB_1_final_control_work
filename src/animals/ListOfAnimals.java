package animals;

import java.util.LinkedList;
import java.util.List;

public class ListOfAnimals {

private List<Animal> listOfAnimals = new LinkedList<>();

    public void addAnimal(Animal animal){
        listOfAnimals.add(animal);
    }
    public int getSize() {
        return listOfAnimals.size();
    }
    public Animal getAnimal(int id){
        return listOfAnimals.get(id);
    }
    public List<Animal> getList(){
        return listOfAnimals;
    }
    public Animal getLast(){
        return listOfAnimals.getLast();
    }
    @Override
    public String toString() {
        if (!listOfAnimals.isEmpty()) {
            return "Список животных:\n" +
                    "id\tИмя\t\t\t\tпол\tдата рождения\tсписок команд\n" +
                    listOfAnimals +
                    '\n';
        }
        return "Cписок животных пуст";
    }

}
