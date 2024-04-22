package View;
/**
 * File name: CenterPanel.java
 * Short description: Class for creating a GUI Center Panel
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterPanel extends JPanel {
    //instance variables
    private ArrayList<JButton> headers;
    private ArrayList<JButton> rowData;

    //constructor

    public CenterPanel() {
        super();
        headers = new ArrayList<JButton>();
        rowData = new ArrayList<JButton>();
    }

    public void setupCenterPanel(int rows, int cols) {

        setLayout(new GridLayout(rows + 1, cols));
        //create header labels and add to the panel
        for (int c = 0; c < cols; c++) {
            JButton button = new JButton("L" + c);
            button.setHorizontalAlignment(JLabel.CENTER);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.white);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.setOpaque(true);

            headers.add(button);
            add(headers.get(c));
        }
        //create rowData buttons and add to panel
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton btn = new JButton("B" + r + c);
                btn.setOpaque(true);
                rowData.add(btn);
                add(btn);
            }
        }
        //When changing layout and contents after panel is created
        //need to validate and repaint

        validate();
        repaint();
    }

    public void panelUpdate(ArrayList<ArrayList<String>> rows, ArrayList<String> heads) {
        for (int h = 0; h < heads.size(); h++) {
            headers.get(h).setText(heads.get(h));
        }
        //update the buttons
        int b = 0;//counter for row data list
        for (int d = 0; d < rows.size(); d++) {
            ArrayList<String> data = rows.get(d);
            for (int i = 0; i < data.size(); i++) {
                rowData.get(b).setText(data.get(i));
                b++;
            }
        }
        validate();
        repaint();
    }
    public ArrayList<JButton> getHeaders() {
        return headers;
    }

    public ArrayList<JButton> getRowData() {
        return rowData;
    }
}
