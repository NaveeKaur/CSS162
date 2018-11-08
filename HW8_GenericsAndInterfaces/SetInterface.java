import java.util.*;
/**
 *
 * SetInterface is an Interface for a class project.  It defines some
 * methods for a Set class the student will write.
 * CSS-162
 *
 * @author John Chenault
 * @version 2016
 */
public interface SetInterface <T>
{
    /**
     * Add an item of type T to the interface  Duplicate items will not be
     * added to the set.
     * @param  itemToAdd - what to add.
     */
    void add( T itemToAdd);


    /**
     * Removes an item from the set ( if the item is in the set)  If the item is not
     * in the set this operation does nothing
     * @param  itemToDelete
     */
    void remove( T itemToDelete);


    /**
     * Return if the SetInterface contains an item
     * @param itemToCheck  The item you are looking for
     * @return  true if found.  False if not found.
     */
    boolean contains( T itemToCheck);


    /**
     * Make a union of two sets.  We add all items in either set to a new set and
     * return the new set.
     * @param the 'other' set to add to our set.
     * @return  A new set which is the union of the two sets.
     */
    Set<T>  makeUnion( SetInterface<T> otherSet);


    /**
     * Make an intersection  of two sets.  We add create a new set which only has
     * items in it that are contained in both sets.
     *
     * @param the 'other' set to intersect with
     * @return  A new set which is the intersection  of the two sets.
     */
    Set<T>  makeIntersection( SetInterface<T> otherSet);


    /**
     * Return an iterator for the set.  This is used to walk thought all elements
     * in the set
     * @return  The iterator
     */
    Iterator<T> getIterator();


    /**
     * Tell the caller how many elements are in the set
     * @returns int with the number of elements
     */
    int size();
}



