package Model;
/**
 * File name: TableMember.java
 * Short description: Interface TableMember to be used in a display application
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */

import java.util.ArrayList;

public interface TableMember {

    public String getAttribute(int n);

    public ArrayList<String> getAttributes();

    public String getAttributeName(int n);

    public ArrayList<String> getAttributeNames();
}
