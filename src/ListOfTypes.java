import java.util.LinkedList;
import java.util.List;

public class ListOfTypes {
    private List<TypeOfAnimal> typeOfAnimals = new LinkedList<>();

    public void addType(TypeOfAnimal type){
        typeOfAnimals.add(type);
    }
    public int getSize() {
        return typeOfAnimals.size();
    }
    public List<TypeOfAnimal> getList(){
        return typeOfAnimals;
    }
    @Override

    public String toString() {
        if (!typeOfAnimals.isEmpty()) {
            return "Список игрушек:\n" +
                    typeOfAnimals +
                    '\n';
        }
        return "Cписок игрушек пуст";
    }
}


