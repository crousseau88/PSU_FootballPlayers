/**
 * Filename: App.java
 * Short description: Application class for program
 * IST 242 Assignment:M05 - W11: L04C
 *
 * @author Chad Rousseau
 * @version 4/2/2024
 */
import Controller.Controller;
import Model.Model;
import View.View;

public class App {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);
    }
}
