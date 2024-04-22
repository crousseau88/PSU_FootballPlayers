package Model;
/**
 * Filename: Model.java
 * Short description: Model class for program
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
import java.util.ArrayList;

public class Model {
    //instance variables

    private FootballPlayerData fpData;
    private ArrayList<ArrayList<String>> lines;

    public Model() {
        fpData = new FootballPlayerData();
        //set data for Displayable interface
        fpData.setFirstLineToDisplay(0);
        fpData.setLastLineToDisplay(19);
        fpData.setLinesBeingDisplayed(20);

    }

    /**
     * method to get lines of data
     * @return lines of data
     */
    public ArrayList<ArrayList<String>> getLines() {
        // used for next week when calling getLines
        lines = fpData.getLines(fpData.getFirstLineToDisplay(), fpData.getLastLineToDisplay());
        return lines;
    }


    //getters and setters
    public FootballPlayerData getFpData() {
        return fpData;
    }

    public void setFpData(FootballPlayerData fpd) {
        this.fpData = fpd;
    }
}
