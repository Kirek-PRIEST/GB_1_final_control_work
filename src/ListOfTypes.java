import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListOfTypes {
    private ArrayList<TypeOfAnimal> typeOfAnimals = new ArrayList<>();

    /* Продумать работу листа видов животных!!!!! */


    public void addType(String typeOfAnimal, String type){
            TypeOfAnimal adding = new TypeOfAnimal(typeOfAnimal, type);
        typeOfAnimals.add(adding);
    }
    public int getSize() {
        return typeOfAnimals.size();
    }
    public ArrayList<TypeOfAnimal> getList(){
        return typeOfAnimals;
    }
    public  String getType(int a){
        return typeOfAnimals.get(a).getTypeOfAnimal();
    }
    @Override

    public String toString() {
        if (!typeOfAnimals.isEmpty()) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < typeOfAnimals.size(); i++) {
                result.append(i+ 1).append("\t|  ").append(typeOfAnimals.get(i).getTypeOfAnimal()).append("\t\t|\t").append(typeOfAnimals.get(i).getType()).append("\n");
            }
            return "N\t|  Вид\t\t\t|\tТип\n"+
                    result;
        }
        return "Cписок видов животных пуст";
    }
}


