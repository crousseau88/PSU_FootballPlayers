package View;

import javax.swing.*;
import java.awt.*;

public class WestPanel extends JPanel {

    //instance variables
    //three buttons for sorting algorithms
    private JButton selection;
    private JButton merge;// merge sort
    private JButton quick;//quick sort

    //constructor
    public WestPanel(){
        setLayout(new GridLayout(4,1, 5,5));

        // create label
        JLabel label = new JLabel("Choose SORT type", SwingConstants.CENTER);
        label.setForeground(Color.white);
        label.setBackground(Color.blue);
        label.setOpaque(true);
        add(label);
        //create buttons
        selection = new JButton("Selection Sort");
        selection.setBackground(Color.LIGHT_GRAY);
        selection.setOpaque(true);
        add(selection);

        merge = new JButton("Merge Sort");
        merge.setForeground(Color.WHITE);
        merge.setBackground(Color.GRAY);
        merge.setOpaque(true);
        add(merge);

        quick = new JButton("Quick Sort");
        quick.setBackground(Color.LIGHT_GRAY);
        quick.setOpaque(true);
        add(quick);

    }

    public JButton getSelection() {
        return selection;
    }

    public void setSelection(JButton selection) {
        this.selection = selection;
    }

    public JButton getMerge() {
        return merge;
    }

    public void setMerge(JButton merge) {
        this.merge = merge;
    }

    public JButton getQuick() {
        return quick;
    }

    public void setQuick(JButton quick) {
        this.quick = quick;
    }
}
