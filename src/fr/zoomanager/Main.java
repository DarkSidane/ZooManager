package fr.zoomanager;

import fr.zoomanager.controller.ZooController;
import fr.zoomanager.model.Zoo;
import fr.zoomanager.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        ConsoleView view = new ConsoleView();
        ZooController controller = new ZooController(zoo, view);
        controller.start();
    }
}
