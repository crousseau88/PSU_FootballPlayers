package Model;

/**
 * File name: Person.java
 * Short description: Class to create a person object
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */

public class Person {
    //instance variables
    private String name;

    private Height height;

    private int weight;

    private String hometown;

    private String highSchool;

    /**
     * Constructor using fields
     *
     * @param nm String name
     * @param wt int weight
     * @param ht String hometown
     * @param hs String highSchool
     */
    public Person(String nm, Height hgt, int wt, String ht, String hs) {
        name = nm;
        height = hgt;
        weight = wt;
        hometown = ht;
        highSchool = hs;
    }

    /**
     * No argument constructor
     * Constructs a default object when no input parameters are provided
     */
    public Person() {
        name = "";
        height = new Height();
        weight = 0;
        hometown = "N/A";
        highSchool = "N/A";
    }


    /**
     * Getter for name
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for weight
     *
     * @return int weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter for weight
     *
     * @param weight int weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Getter for hometown
     *
     * @return String hometown
     */
    public String getHometown() {
        return hometown;
    }

    /**
     * Setter for hometown
     *
     * @param hometown String hometown
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * Getter for highSchool
     *
     * @return String highSchool
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * Setter for highSchool
     *
     * @param highSchool String highSchool
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    /**
     * Getter for height
     *
     * @return height
     */
    public Height getHeight() {
        return height;
    }

    /**
     * Setter for height
     *
     * @param height value from Height class
     */
    public void setHeight(Height height) {
        this.height = height;
    }

    /**
     * toString method for displaying data
     *
     * @return String of all stored data
     */
    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", " + height.toString() +
                ", weight= " + weight +
                ", hometown= " + hometown +
                ", highSchool= " + highSchool +
                '}';
    }

}
