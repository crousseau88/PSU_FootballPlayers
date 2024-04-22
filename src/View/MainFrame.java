package View;
/**
 * File name: MainFrame.java
 * Short description: Class to create GUI Mainframe
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
import javax.swing.*;

public class MainFrame extends JFrame {
    //
    private InitialPanel ip;

    public MainFrame() {
        super("L04C - FootballPlayerData: Rousseau");
        setupLayoutForMacs();
        //create panel
        ip = new InitialPanel();
        add(ip);

        //===========================
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 480);
        setVisible(true);


    }

    private void setupLayoutForMacs() {
        // On some MACs it might be necessary to have the statement below
        //for the background color of the button to appear
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }
    //getters and setters
    public InitialPanel getIp() {
        return ip;
    }

    public void setIp(InitialPanel ip) {
        this.ip = ip;
    }
}
