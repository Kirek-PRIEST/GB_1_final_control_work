package animals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Animal {

private int id;
private String name;
private char sex;
private  String type;
private Date birthdayDate;
private ArrayList<String> commands;

    public Animal(int id, String name, char sex, String type, Date birthdayDate, ArrayList<String> commands) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.type = type;
        this.birthdayDate = birthdayDate; //переделвть дату из стринка в формат даты!!!
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

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setCommands(ArrayList<String> commands) {
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

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return String.format(
                "%s \t" +
                "%s\t" +
                "%s\t" +
                "%s\t" +
                "%s\t" +
                "%s", id, name, sex, type, birthdayToString(birthdayDate), commands);

    }
    private String birthdayToString(Date date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }
}
