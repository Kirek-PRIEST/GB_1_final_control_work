package types;

public class TypeOfAnimal {

    private String typeOfAnimal; //вид животного
    private String type;// тип животного (домашнее/вьючное)

    public TypeOfAnimal(String typeOfAnimal, String type) {

        this.typeOfAnimal = typeOfAnimal;
        this.type = type;

    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public String getType() {
        return type;
    }


    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  typeOfAnimal + "\t" +
                type;
    }
}
