/**
 * Created by Navee on 10/12/16.
 * This class is the base class for all inventory items. It increments
 * the count for each product.
 */
public class InventoryItem {
    static int count =0;
    int id = 0;
    public InventoryItem() {
        count++; //keeps a count of how many times the invertoryItem() has been called i.e. super()
        id=count;
    }

    /**
     * toString: calls getAttributes that provides a String with the ID.
     * @return String
     */
    public String toString() {
        return getAttributes();
    }

    /**
     * returns the number of times the object InventoryItem has been called
     * @return count
     */
    public int getCount(){
        return  count;
    }

    public String getAttributes() {
        return Integer.toString(id);
    }
}
