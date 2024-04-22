package Model;

import java.util.ArrayList;

/**
 * Filename: FootballPlayer.java
 * Short description: Class to create a football player
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
public class FootballPlayer extends Person implements TableMember {
    private int number;
    private String position;

    //Constructor for FootballPlayer object
    public FootballPlayer(String nm, Height hgt, int wt, String ht, String hs, int number, String position) {
        super(nm, hgt, wt, ht, hs);
        this.number = number;
        this.position = position;
    }

    //no arg constuctor
    public FootballPlayer() {

    }

    /**
     * Getter for FootballPlayers number
     *
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter for FootballPlayers number
     *
     * @param number Int param for number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter for FootballPlayers position
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Setter for FootballPlayers position
     *
     * @param position String for position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + " FootballPlayer{" +
                "number= " + number +
                ", position=" + position +
                '}';
    }

    /**
     * Method to retrieve each attribute
     * @param n represents the index of the selected attribute
     *          0 means the first attribute
     * @return attribute
     */
    @Override
    public String getAttribute(int n) {
        switch (n) {
            case 0:
                return Integer.toString(number);
            case 1:
                return position;
            case 2:
                return getName();
            case 3:
                return getHeight().toString();
            case 4:
                return Integer.toString(getWeight());
            case 5:
                return getHometown();
            case 6:
                return getHighSchool();

        }
        return null;

    }

    /**
     * Method to get attributes from a list
     * @return attributes
     */
    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> atts = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            atts.add(getAttribute(i));
        }
        return atts;
    }

    /**
     * Method for getting the name of each attribute
     * @param n represents the index of the selected attribute
     *          0 means the first attribute
     * @return name of the attribute
     */
    @Override
    public String getAttributeName(int n) {
        switch (n) {
            case 0:
                return "number";
            case 1:
                return "position";
            case 2:
                return "name";
            case 3:
                return "height";
            case 4:
                return "weight";
            case 5:
                return "hometown";
            case 6:
                return "highSchool";
        }
        return null;
    }

    /**
     * Method to get the attributes names from a list
     * @return attributes names
     */
    @Override
    public ArrayList<String> getAttributeNames() {
        ArrayList<String> attNames = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            attNames.add(getAttributeName(i));
        }
        return attNames;
    }
}
