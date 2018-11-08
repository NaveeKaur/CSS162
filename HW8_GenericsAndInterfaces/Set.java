import java.util.HashSet;
import java.util.Iterator;
/**
 * Write a description of class Set here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Set<T> implements SetInterface<T>
{
    HashSet mySet = new HashSet();
    int n = 0;
    /**
     * Add an item of type T to the interface  Duplicate items will not be
     * added to the set.
     * @param  itemToAdd - what to add.
     */
    public void add( Object itemToAdd) {
        if (itemToAdd == null) {
            return;
        }

        if(mySet.add(itemToAdd)) {
            return;
        }
        else {
            System.err.println("Failed to add item: " + itemToAdd.toString());
        }
    }

    /**
     * Removes an item from the set ( if the item is in the set)  If the item is not
     * in the set this operation does nothing
     * @param  itemToDelete : item to remove.
     */
    public void remove(Object itemToDelete) {
        if (itemToDelete == null) {
            throw new NullPointerException();
        }

        if(mySet.remove(itemToDelete)) {
            return;
        }
        else {
            System.err.println("Failed to remove item: " +itemToDelete.toString());
        }
    }

    /**
     * Return if the SetInterface contains an item
     * @param itemToCheck : The item you are looking for
     * @return  true if found.  False if not found.
     */
    public boolean contains(Object itemToCheck) {
        boolean ret = mySet.contains(itemToCheck);
        return ret;
    }

    /**
     * Make a union of two sets.  We add all items in either set to a new set and
     * return the new set.
     * @param otherSet : 'other' set to add to our set.
     * @return  A new set which is the union of the two sets.
     */
    public Set<T>  makeUnion( SetInterface<T> otherSet) {
        Set <T> newSet = new Set <T>();
        Iterator<T> iter1 = this.getIterator();
        Iterator<T> iter2 = otherSet.getIterator();
        while(iter1.hasNext()) {
            newSet.add(iter1.next());
        }
        while(iter2.hasNext()) {
            newSet.add(iter2.next());
        }
        return newSet;
    }

    /**
     * Make an intersection  of two sets.  We add create a new set which only has
     * items in it that are contained in both sets.
     *
     * @param otherSet : 'other' set to intersect with
     * @return  A new set which is the intersection  of the two sets.
     */
    public Set<T>  makeIntersection( SetInterface<T> otherSet){
        SetInterface <T> newSet = new Set <T>();
        Iterator<T> other = otherSet.getIterator();
        while(other.hasNext() ) {
            T otherObj = other.next();
            if(this.contains(otherObj)) {
                newSet.add(otherObj);
            }
        }
        return (Set<T>) newSet;
    }

    /**
     * Return an iterator for the set.  This is used to walk thought all elements
     * in the set
     * @return  The iterator
     */
    public Iterator getIterator() {
        return mySet.iterator();
    }

    /**
     * Tell the caller how many elements are in the set
     * @returns int with the number of elements
     */
    public int size() {
        return mySet.size();
    }
}
