public class Animal {

private int id;
private String name;
private char sex;
private  String type;
private String birthdayDate;
private String commands;

    public Animal(int id, String name, char sex, String type, String birthdayDate, String commands) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.type = type;
        this.birthdayDate = birthdayDate;
        this.commands = commands;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getType() {
        return type;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public String getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return String.format(
                "ID = %s \n" +
                "Имя = %s\n" +
                "Пол = %s\n" +
                "Вид = %s\n" +
                "Дата рождения = %s\n" +
                "Выполняемые команды = %s", id, name, sex, type, birthdayDate, commands) +
                "\n \n";

    }
}
