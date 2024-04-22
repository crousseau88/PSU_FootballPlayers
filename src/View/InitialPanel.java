package View;
/**
 * File name: InitialPanel.java
 * Short description: Class for creating a GUI Panel
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel {
    //instance variables for panels
    private CenterPanel cp;
    private WestPanel wp;

    public InitialPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);
        //create panel
        cp = new CenterPanel();
        add(cp, "Center");
        wp = new WestPanel();
        add(wp, "West");

    }
    //implement sets and gets
    public WestPanel getWp() {
        return wp;
    }

    public void setWp(WestPanel wp) {
        this.wp = wp;
    }

    public CenterPanel getCp() {
        return cp;
    }

    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }
}
