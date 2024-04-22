package Model;

import com.sun.javafx.collections.SortableList;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * File name: FootballPlayerData.java
 * Short description: Class to read FootballPlayer data from XML file
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
public class FootballPlayerData implements TableData, Displayable, Sortable {
    // instance variables
    private ArrayList<FootballPlayer> players;
    private int firstLineToDisplay;
    private int lineToHighlight;
    private int lastLineToDisplay;
    private int linesBeingDisplayed;
    private int sortField;
    private int sortType;
    private Comparator<FootballPlayer> field;


    public FootballPlayerData() {
        players = new ArrayList<>();
        loadTable();
        System.out.println("Number of players loaded: " + players.size());
    }

    /**
     * calls ReadPlayersFromXML method to load a table of data
     */
    @Override
    public void loadTable() {
        ReadPlayersFromXML();
    }

    /**
     * Reads Player data from XML file
     */
    public void ReadPlayersFromXML() {
        try {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null) {
                try {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);

                } catch (ArrayIndexOutOfBoundsException theend) {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {
            xx.printStackTrace();
        }
    }

    /**
     * gets the list of players
     *
     * @return
     */
    @Override
    public ArrayList getTable() {
        return players;
    }

    /**
     * Get attributes names or headers from the list
     *
     * @return returns headers
     */
    @Override
    public ArrayList<String> getHeaders() {
        //take 1 element from players and get the attribute names from football player
        ArrayList<String> headers = players.get(0).getAttributeNames();
        return headers;
    }

    /**
     * Retrieves line of attributes of football player data from list
     *
     * @param line the line to get attributes from
     * @return list of data
     */
    @Override
    public ArrayList<String> getLine(int line) {
        //index of football player you want and getAttributes of football player data

        ArrayList<String> data = players.get(line).getAttributes();
        return data;
    }


    /**
     * Retrieves FootballPlayer attributes from list to create 2D array list of data
     *
     * @param firstLine start of index
     * @param lastLine  enc of index
     * @return list of data
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        //loop to call getLines method in tabledata to create a 2d arraylist
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        //use loop to grab data from elements firstLine through lastLine
        //add them to the list arraylist
        for (int i = firstLine; i <= lastLine; i++) {
            ArrayList<String> line = getLine(i);
            list.add(line);
        }
        return list;
    }

    //gets and sets
    @Override
    public int getFirstLineToDisplay() {
        return firstLineToDisplay;
    }

    @Override
    public int getLineToHighlight() {
        return lineToHighlight;
    }

    @Override
    public int getLastLineToDisplay() {
        return lastLineToDisplay;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineToDisplay = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        lineToHighlight = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineToDisplay = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    @Override
    public void sort(int sortType, int sortField) {
        // sortType: 1) Selection, 2) Merge, 3) Quick
        // sortField: 0-4 fields for course (0-6 for football player)
        setSortField(sortField);
        setSortType(sortType);
        System.out.println("Sort Method" + sortType + " " + sortField); // shows correct info is passed in
        //switch to handle options

        switch (sortType) {
            case 1: //Selection sort written from scratch
                selectionSort();
                break;
            case 2: // merge sort using Collections.sort()
                Collections.sort(players, field);
                break;
            case 3: // quick sort using Arrays.sort()
                //convert from arraylist to array and back again
                FootballPlayer[] array = copyList(players);
                Arrays.sort(array, field);// (array, field comparator)
                players = new ArrayList<>(Arrays.asList(array));
                break;


        }
    }

    private FootballPlayer[] copyList(ArrayList<FootballPlayer> players) {
        FootballPlayer[] arr = new FootballPlayer[players.size()];
        for (int i = 0; i < players.size(); i++) {
            arr[i] = players.get(i);
        }
        return arr;
    }

    private void selectionSort() {
        //loop to process data
        for (int i = 0; i < players.size(); i++) {
            //find lowest value starting at position i
            int minPosition = minimumPosition(players, i);
            //swap if necessary
            if (minPosition != i) {
                swap(players, minPosition, i);
            }

        }
    }

    private void swap(ArrayList<FootballPlayer> players, int a, int b) {
        //save off value in pos a into temp
        FootballPlayer temp = players.get(a);

        players.set(a, players.get(b));
        players.set(b, temp);
    }

    private int minimumPosition(ArrayList<FootballPlayer> players, int from) {
        //modify to handle height and number separately for homework
        //nested if or seperate for loop to handle one or other for height/number
        //trying to sort integer values in order
        //if sortField = 3 if sortField = 0
        int minPosition = from;

        for (int a = from; a < players.size(); a++) {
            if (sortField == 0) {

                int currentValue = Integer.parseInt(players.get(a)
                        .getAttribute(sortField));//parses attribute to an integer to compare
                int minValue = Integer.parseInt(players.get(minPosition)
                        .getAttribute(sortField));//parses attribute to an integer to compare

                if (currentValue < minValue) {
                    minPosition = a;
                }
            } else if (sortField == 3) {

                int currentHeight = players.get(a).getHeight().getHeightInInches();
                int minHeight = players.get(minPosition).getHeight().getHeightInInches();

                if (currentHeight < minHeight) {
                    minPosition = a;
                }
            } else {

                if (players.get(a).getAttribute(sortField).compareTo(
                        players.get(minPosition).getAttribute(sortField)) < 0) {
                    minPosition = a;
                }
            }
        }

        return minPosition;
    }

    @Override
    public int getSortType() {
        return sortType;
    }

    @Override
    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void setSortField(int sortField) {
        this.sortField = sortField;
        //also set the field variable -- Comparator
        switch (sortField) {
            case 0:
                field = sortByNumber;
                break;
            case 1:
                field = sortByPosition;
                break;
            case 2:
                field = sortByName;
                break;
            case 3:
                field = sortByHeight;
                break;
            case 4:
                field = sortByWeight;
                break;
            case 5:
                field = sortByHometown;
                break;
            case 6:
                field = sortByHighSchool;
        }

    }

    Comparator<FootballPlayer> sortByNumber = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return Integer.compare(o1.getNumber(), o2.getNumber());
        }
    };

    Comparator<FootballPlayer> sortByPosition = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            //This method will compare and handle courseName
            return o1.getPosition().compareTo(o2.getPosition());

        }
    };
    //comparators needed for sorting via merge and quick
    Comparator<FootballPlayer> sortByName = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            //This method will compare and handle courseName
            return o1.getName().compareTo(o2.getName());

        }
    };

    //use for football player number and height may want to convert height to inches to compare

    Comparator<FootballPlayer> sortByHeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getHeight().getHeightInInches() < o2.getHeight().getHeightInInches()) {
                return -1;
            }
            if (o1.getHeight().getHeightInInches() == o2.getHeight().getHeightInInches()) {
                return -0;
            }
            return 1;
        }
    };

    Comparator<FootballPlayer> sortByWeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getWeight() < o2.getWeight()) {
                return -1;
            }
            if (o1.getHeight() == o2.getHeight()) {
                return -0;
            }
            return 1;
        }
    };

    Comparator<FootballPlayer> sortByHighSchool = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getHighSchool().compareTo(o2.getHighSchool());
        }
    };

    Comparator<FootballPlayer> sortByHometown = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            String hometown1 = o1.getHometown();
            String hometown2 = o2.getHometown();
            return hometown1.compareToIgnoreCase(hometown2);
        }
    };

}
