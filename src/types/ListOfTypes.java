package types;

import java.util.ArrayList;


public class ListOfTypes {
    private ArrayList<TypeOfAnimal> typeOfAnimals = new ArrayList<>();


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
    public  TypeOfAnimal getType(int a){
        return typeOfAnimals.get(a);
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


