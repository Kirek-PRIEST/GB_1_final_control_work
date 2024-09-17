package animals.animalsActions;

import animals.ListOfAnimals;
import printer.PrinterMenu;

public class ToPrinterMenu {
    public void toPrinterMenu(ListOfAnimals pets, ListOfAnimals packAnimals){
        PrinterMenu menu = new PrinterMenu();
        menu.menu(pets, packAnimals);
    }
}
