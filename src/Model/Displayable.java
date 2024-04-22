
package Model;

/**
 * File name: Displayable.java
 * Short description: Interface Displayable to be used in a display application
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
public interface Displayable {

   public int getFirstLineToDisplay(); 
   public int getLineToHighlight(); //will be used in another project
   public int getLastLineToDisplay(); 
   public int getLinesBeingDisplayed(); 
   
   public void setFirstLineToDisplay(int firstLine); 
   public void setLineToHighlight(int highlightedLine); //will be used in another project
   public void setLastLineToDisplay(int lastLine); 
   public void setLinesBeingDisplayed(int numberOfLines); 
       
}