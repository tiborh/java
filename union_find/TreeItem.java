import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
/**
 * Tree item to be used with Union Find
 * 
 * @author tibor
 * @version 0.01
 */
public class TreeItem
{
    private final int itemID;
    private int upID;
    private Set<Integer> downIDs;

    /**
     * Constructor for objects of class TreeItem:
     * when the object is created, the item points at itself
     * both as an up and down item. If it remains so, the item is unconnected.
     */
    public TreeItem(int id)
    {
        itemID = upID = id;
        downIDs = new HashSet<Integer>();
    }

    /**
     * get the ID of the current treeItem
     * 
     * @return the ID of the current treeItem
     */
    public int getID()
    {
        return itemID;
    }
    
    /**
     * Get the pointer to the item rootwise
     * 
     * @param  id  the ID of the item closer to the root element (than the current element)
     *             if this ID is is the same as the itemID, then the current element is the
     *             root element.
     */
    public int getUpID(int id)
    {
        return upID;
    }
    
    /**
     * Add an item as the upItem
     * 
     * @param  anItem  a treeItem to add as upItem
     */
    public void setUpItem(TreeItem anItem)
    {
        setUpID(anItem.getID());
    }
    
    /**
     * Set the pointer to the item rootwise
     * 
     * @param  id  the ID of the item closer to the root element (than the current element)
     *             if this ID is is the same as the itemID, then the current element is the
     *             root element.
     */
    public void setUpID(int id)
    {
        upID = id;
    }
    
    /**
     * Get the pointer to the item rootwise
     * 
     * @return  the values of ids of immediate down the tree IDs as a string
     */
    public String getDownIDs()
    {
        return downIDs.toString(); 
    }
    
    /**
     * checks if id is in the downID set
     * 
     * @param id an itemID to check
     */
    public boolean isDownID(int id)
    {
        if (downIDs.isEmpty())
            return false;
        if (downIDs.contains(new Integer(id)))
            return true;
        return false;
    }
    
    /**
     * Add an item as down item in the item hierarchy
     * 
     * @param  anItem an item to add as a down item in the tree
     */
    public void addDownItem(TreeItem anItem)
    {
        addDownID(anItem.getID());
    }
    
    /**
     * Add an ID as downID to downIDs set
     * 
     * @param  id  the ID of the item further from the root element (than the current element)
     */
    public void addDownID(int id)
    {
        if (id == itemID)
            constants.logger.warning("A current ID (" + id + ") cannot be added as a subitem.");
        else
            downIDs.add(id);
    }

    /**
     * Remove an ID from downIDs set
     * 
     * @param  id  the ID of the item further from the root element (than the current element)
     *             If id is not in the set, Error is logged. 
     */
    public void removeDownID(int id)
    {
        Integer anID = new Integer(id);
        if (downIDs.contains(anID))
            downIDs.remove(anID);
        else
            constants.logger.warning("ID " + id + " is not a downID, so it cannot be removed.");
    }
    
    /**
     * Checks if the item is unconnected to other items
     * 
     * @return true if up and down ID's are the same 
     *         false if downID and upID are different
     */
    public boolean isUnconnected()
    {
        if (downIDs.isEmpty())
            return true;
            
        if (downIDs.size() > 0)
            return false;
            
        return false;
    }
    
    /**
     * Checks if current item is at the root of a chain
     * 
     * @return true if current item is a root item
     *         false if current item is not a root item
     */
    public boolean isRootItem()
    {
        if (upID == itemID)
            return true;
        else
            return false;
    }
    
    /**
     * Examines the equality of two TreeItems
     * 
     * return true if the two references refer to the same object
     *             or their itemID's are equal
     *        false otherwise.
     */
    public boolean equals(TreeItem other)
    {
        if (this == other)
            return true;
        if (this.itemID == other.itemID)
            return true;
        else
            return false;
    }    
    
    /**
     * Checks if everything works as it should
     * 
     * @param argv currently no command line argument is processed
     */
    public static void main(String[] argv)
    {
        TreeItem first = new TreeItem(1);
        TreeItem second = new TreeItem(2);
        TreeItem third = new TreeItem(3);
        TreeItem fourth = new TreeItem(4);
        second.setUpItem(first);
        second.addDownItem(third);
        second.addDownItem(fourth);
        System.out.println("Self-check has passed.");
    }
}
