package utils;


import animals.ListOfAnimals;

public class PrintAnimalsList {
    public void print(ListOfAnimals list){

        String leftAlignFormat = "| %-2s | %-16s |  %-2s | %-10s | %-10s | %-13s | %-40s |%n";

        System.out.format("+----+------------------+-----+------------+------------+---------------+------------------------------------------+%n");
        System.out.format("| ID | Имя              | Пол | Вид        | Тип        | Дата рождения | Список Команд                            |%n");
        System.out.format("+----+------------------+-----+------------+------------+---------------+------------------------------------------+%n");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.format(leftAlignFormat,
                    list.getAnimal(i).getId(),
                    list.getAnimal(i).getName(),
                    list.getAnimal(i).getSex(),
                    list.getAnimal(i).getType().getType(),
                    list.getAnimal(i).getType().getTypeOfAnimal(),
                    list.getAnimal(i).birthdayToString(list.getAnimal(i).getBirthdayDate()),
                    String.join(",", list.getAnimal(i).getCommands()));
        }
        System.out.format("+----+------------------+-----+------------+------------+---------------+------------------------------------------+%n");
    }
}
