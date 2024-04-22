package Model;
/**
 * File name: Sortable.java
 * Short description: Interface Sortable for application
 * IST 242 Assignment:M06 - W12: L05
 *
 * @author Chad Rousseau
 * @version 4/18/24
 */
public interface Sortable {
    //methods for sortable interface

    public void sort(int sortType, int sortField);
    public int getSortType();
    public void setSortType(int sortType);
    public int getSortField();
    public void setSortField(int sortField);
}
