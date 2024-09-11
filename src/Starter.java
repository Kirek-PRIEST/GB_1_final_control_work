public class Starter {
    public void Start() {
         ListOfTypes typesList = new ListOfTypes();
         typesList.addType("Кошка", "Домашнее");
        typesList.addType("Капибара", "Домашнее");
        typesList.addType("Верблюд", "Вьючное");
        System.out.println(typesList);
    }
}
