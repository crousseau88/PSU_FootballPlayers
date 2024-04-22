package Model;
/**
 * File name: TableData.java
 * Short description: Interface TableData for application
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
import java.util.ArrayList;

public interface TableData
{

    public void loadTable();

    public ArrayList<TableMember> getTable();

    public ArrayList<String> getHeaders();

    public ArrayList<String> getLine(int line);

    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine);

}
