/**
 * implement a Queue class that inherits from the LList class.
 * This class should be quite short as it primarily wraps methods
 * in the base class.
 * @author Created by Navee on 11/19/16.
 */
public class Queue extends LList {
    /**
     * Adds an element to the queue
     * @param next
     */
    void enqueue(String next) {
        super.insert(next);
    }

    /**
     * Removes and returns the oldest item from the list
     * Returns NULL if no elements
     */
    String dequeue() {
        if (super.numNodes() == 0) {
            return null;
        } else {
            String butter = super.getNode(numNodes() - 1).getData();
            try {
                super.remove(numNodes() - 1);
            } catch (LinkedListException e) {
                e.printStackTrace();
            }
            return butter;
        }


    }

    /**
     * Returns the oldest item but does not remove it.
     * Returns NULL if no elements.
     */
    String peek() {
        if (super.numNodes() == 0) {
            return null;
        } else {
            return super.getNode(numNodes() - 1).getData();
        }
    }

}
