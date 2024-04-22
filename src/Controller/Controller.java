package Controller;
/**
 * Filename: Controller.java
 * Short description:Controller class for program
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */

import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class Controller {

    private Model model;
    private View view;

    public Controller(View v, Model m) {
        model = m;
        view = v;

        view.getCp().setupCenterPanel(
                model.getFpData().getLinesBeingDisplayed(),//num rows
                model.getFpData().getHeaders().size());//num columns

        view.getCp().panelUpdate(
                model.getLines(), model.getFpData().getHeaders()
        );
        //Add Listeners
        addListeners();
        addScrolling();
        addSorting();

    }

    private void addSorting() {
        view.getMf().getIp().getWp().getSelection().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.getFpData().setSortType(1);//sets sort type for switch statement
                        model.getFpData().sort(1, model.getFpData().getSortField());
                        view.getMf().getIp().getWp().getSelection().setBackground(Color.ORANGE);
                        view.getMf().getIp().getWp().getMerge().setBackground(Color.GRAY);
                        view.getMf().getIp().getWp().getQuick().setBackground(Color.LIGHT_GRAY);
                    }
                }
        );
        view.getMf().getIp().getWp().getMerge().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.getFpData().setSortType(2);//sets sort type for switch statement
                        model.getFpData().sort(2, model.getFpData().getSortField());
                        view.getMf().getIp().getWp().getSelection().setBackground(Color.LIGHT_GRAY);
                        view.getMf().getIp().getWp().getMerge().setBackground(Color.ORANGE);
                        view.getMf().getIp().getWp().getQuick().setBackground(Color.LIGHT_GRAY);
                    }
                }
        );
        view.getMf().getIp().getWp().getQuick().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.getFpData().setSortType(3);//sets sort type for switch statement
                        model.getFpData().sort(3, model.getFpData().getSortField());
                        view.getMf().getIp().getWp().getSelection().setBackground(Color.LIGHT_GRAY);
                        view.getMf().getIp().getWp().getMerge().setBackground(Color.GRAY);
                        view.getMf().getIp().getWp().getQuick().setBackground(Color.ORANGE);
                    }
                }
        );
    }

    private void addScrolling() {
        view.getCp().addMouseWheelListener(new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            int units = e.getUnitsToScroll();
            System.out.println("units: " + units);
            //code to make table scroll
            //modify variables in CourseData - displayable
            int first = model.getFpData().getFirstLineToDisplay() + units;
            System.out.println("first 1: " + first);
            if( first < 0) first = 0;//checks top most
            //check bottom most
            if(first > model.getFpData().getTable().size() -
                    model.getFpData().getLinesBeingDisplayed()){
                first -= units;
            }
            System.out.println("first 2: " + first);
            //reset var in courseData - firstLineToDisplay
            model.getFpData().setFirstLineToDisplay(first);
            //set last line to display
            int last = first + model.getFpData().getLinesBeingDisplayed() - 1;
            System.out.println("last: " + last);
            model.getFpData().setLastLineToDisplay(last);
            view.getCp().panelUpdate(model.getLines(),
                    model.getFpData().getHeaders());
        }
    });
    }

    private void addListeners() {
        final ArrayList<JButton> head = view.getMf().getIp().getCp().getHeaders();
        for(int i = 0; i < head.size(); i++){
            JButton btn = head.get(i);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton obj = (JButton) e.getSource();
                    //loop to reset all buttons
                    for(int b = 0; b < head.size(); b++){
                        head.get(b).setBackground(Color.gray);
                        if(head.get(b) == obj){
                            model.getFpData().setSortField(b);
                            System.out.println("sort b: " + model.getFpData().getSortField());
                        }
                    }
                    obj.setBackground(Color.blue);
                    // get updated data and pass to view
                    model.getFpData().sort(model.getFpData().getSortType(), model.getFpData().getSortField());
                    view.getCp().panelUpdate(model.getLines(), model.getFpData().getHeaders());
                }
            });
        }
    }

    //getters and setters
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}


