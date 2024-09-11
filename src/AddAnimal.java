import java.time.Year;
import java.util.Scanner;

public class AddAnimal {

    public ListOfAnimals addingToy(ListOfAnimals list, ListOfTypes types) {
        int id = list.getSize() + 1;
        Animal newAnimal = new Animal(id,
                prompt("Введите имя животного: "),
                sex(),
                type(types),
                birthday(),
                commands()
        );
        list.addAnimal(newAnimal);
        return list;
    }


    private Character sex() {
        String input = prompt("Введите пол животного (М/Ж): ").toUpperCase();
        if (input.length() > 1) {
            System.out.println("Пол животного введён некорректно. Введите М, или Ж");
            sex();
        } else if (input.charAt(0) != 'M' && input.charAt(0) != 'Ж') {
            System.out.println("Пол животного введён некорректно. Введите М, или Ж");
            sex();
        }
        return input.charAt(0);
    } // Ввод пола животного

    private String type(ListOfTypes types) {
        String input = prompt("Выберете вид животного (цифра): ");
        System.out.println("Список доступных видов:");
        System.out.println(types);
        int index = Integer.parseInt(input);
        if (!isNumeric(input) || index < 1 || index > types.getSize()) {
            System.out.println("Выбран неверный вид животного, повторите ввод");
            type(types);
        }
        return types.getType(index);

    } // Ввод вида животного

    private String birthday() {
        String year = prompt("Введите год рождения животного: ");
        while (!year(year)) {
            year = prompt("Введите год рождения животного: ");
        }
        String month = prompt("Введите месяц рождения животного (1 - 12):");
        while (!month(month)) {
            month = prompt("Введите месяц рождения животного (1 - 12):");
        }
        String day = prompt("Введите день рождения животного");
        while (!day(year, month, day)) {
            day = prompt("Введите день рождения животного");
        }
        if (Integer.parseInt(month) < 10) {
            return day + ":0" + month + ":" + year;
        } else return day + ":" + month + ":" + year;

    } // Ввод даты рождения животного

    private boolean year(String year) {
        try {
            int integerYear = Integer.parseInt(year);
            if (Year.now().getValue() - integerYear > 250 || integerYear > Year.now().getValue()) {
                System.out.println("Введён неверный год рождения животного.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно введён год рождения животного.");
            return false;
        }
        return true;
    } //проверка правильности введённого года

    private boolean month(String month) {
        try {
            int integerMonth = Integer.parseInt(month);
            if (integerMonth < 1 || integerMonth > 12) {
                System.out.println("Неверно введён месяц рождения живртного.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно введён месяц рождения животного.");
            return false;
        }
        return true;
    } // проверка правильности введённого месяца

    private boolean day(String year, String month, String day) {
        try {
            int integerDay = Integer.parseInt(day);
            int integerMonth = Integer.parseInt(month);
            int integerYear = Integer.parseInt(year);
            if (integerMonth != 1 && integerMonth != 3 && integerMonth != 5 && integerMonth != 7 && integerMonth != 8 && integerMonth != 10 && integerMonth != 12) {
                if (integerMonth == 2) {
                    if ((integerYear % 4 == 0 && integerYear % 100 != 0) || (integerYear % 400 == 0)) {
                        if (integerDay > 29 || integerDay < 1) {
                            System.out.println("Неверно введён День рождения живртного. (" + year + " високосный. Введите день рождения животного (число от 1 до 29)");
                            return false;
                        }
                    } else {
                        if (integerDay < 1 || integerDay > 28) {
                            System.out.println("Неверно введён День рождения живртного. (" + year + " не високосный. Введите день рождения животного (число от 1 до 28)");
                            return false;
                        }
                    }
                } else {
                    if (integerDay > 30) {
                        System.out.println("Неверно введён День рождения живртного. В " + integerMonth + "-ом месяце 30 дней");
                        return false;
                    }
                }
            } else {
                if (integerDay < 1 || integerDay > 31) {
                    System.out.println("Неверно введён День рождения живртного.");
                    return false;

                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно введён месяц рождения животного.");
            return false;
        }
        return true;
    } // проверка правильности введённого дня


    private String[] commands() {
        String input = prompt("Введите спсок команд через запятую: ");
        char[] c = input.toCharArray();
        StringBuilder result = new StringBuilder();
        result.append(c[0]);
        for (int i = 1; i < c.length - 1; i++) {
            if (c[i] != ' ' && c[i - 1] != ',') {
                result.append(c[i]);
            }
        }
        input = result.toString();
        return input.split(",");
    } // Баг, если нет пробела после запятой!!!

    private String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
