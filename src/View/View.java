package View;

import java.util.ArrayList;

/**
 * Filename: View.java
 * Short description: View class for program
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
public class View {

    private MainFrame mf;
    private CenterPanel cp;

    //Constructor
    public View() {
        mf = new MainFrame();
        cp = mf.getIp().getCp();
    }

    public CenterPanel getCp() {
        return cp;
    }

    public MainFrame getMf() {
        return mf;
    }

    public void setMf(MainFrame mf) {
        this.mf = mf;
    }

    public void basicDisplay(String s) {
        System.out.println(s);
    }

    public void basicDisplay(ArrayList<String> data) {

        for (String s : data) {
            System.out.print(s + " ");
        }
        System.out.println("\b");
    }

    //not used in this iteration
    public void linesDisplay(ArrayList<ArrayList<String>> arrOfArr) {
        for (int i = 0; i < arrOfArr.size(); i++) {
            basicDisplay(arrOfArr.get(i));
        }
    }


}
