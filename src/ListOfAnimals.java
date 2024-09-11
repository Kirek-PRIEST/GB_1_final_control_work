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
    public List<Animal> getList(){
        return listOfAnimals;
    }
    @Override

    public String toString() {
        if (!listOfAnimals.isEmpty()) {
            return "Список игрушек:\n" +
                    listOfAnimals +
                    '\n';
        }
        return "Cписок игрушек пуст";
    }

}
