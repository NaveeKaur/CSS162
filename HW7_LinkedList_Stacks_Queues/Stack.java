/**
 * Build a Stack class that inherits from the LList class.
 * @author Created by Navee on 11/18/16.
 */
public class Stack extends LList {

    /**
     * Inserts to the beginning of the list
     * @param data
     */
    void push(String data) {
        super.insert(data);
    }

    /**
     * Removes from the beginning of the list
     * If the stack is empty – simply return null;
     * @return
     */
    String pop() {
        if(empty()) {
            return null;
        }
        else {
            String retVal =super.getNode(0).getData();
            try {
                super.remove(0);
            } catch (LinkedListException e) {
                e.printStackTrace();
            }
            return retVal;
        }
    }

    /**
     * Returns true if there are no elements in the stack.
     * Else returns false
     */
    boolean empty() {
        return super.numNodes() <= 0;
    }

    /**
     * Returns the element at the top of the stack without removing it
     * If stack is empty returns null
     */
    String peek() {
        return empty() ? null : super.getNode(0).getData();
    }
}
