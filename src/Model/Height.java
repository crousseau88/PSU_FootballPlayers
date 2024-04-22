package Model;

/**
 * Filename: Height.java
 * Short description: Class to create a height attribute
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */

public class Height {
    // Instance Variables -- define your private data
    private int feet;
    private int inches;
    private int heightInInches;


    /**
     * Constructor
     *
     * @param ft int for feet
     * @param in int for inches
     */
    public Height(int ft, int in, int ht) {
        feet = ft;
        inches = in;
        heightInInches = ht;
    }

    /**
     * no arg constructor
     */
    public Height() {
        feet = 0;
        inches = 0;
    }

    /**
     * Getter for feet
     *
     * @return feet
     */
    public int getFeet() {
        return feet;
    }

    /**
     * Setter for feet
     *
     * @param feet
     */
    public void setFeet(int feet) {
        this.feet = feet;
    }

    /**
     * Getter for inches
     *
     * @return inches
     */
    public int getInches() {
        return inches;
    }

    /**
     * Setter for inches
     */
    public void setInches(int inches) {
        this.inches = inches;
    }

    public int getHeightInInches() {
        return (feet * 12) + inches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    /**
     * toString method to create a string using the feet and inches variables
     */
    @Override
    public String toString() {
        return feet + "\'" + inches + "\"";
    }
}
