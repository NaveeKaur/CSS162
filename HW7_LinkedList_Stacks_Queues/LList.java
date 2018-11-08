/**
 * In this assignment, we’ll build three classes that will implement a Linked List,
 * a Stack, and a Queue using a doubly linked list.  The Stack and Queue will
 * inherit from  the LList class ( a linked list implementation)  and so these
 * subclasses will be rather short.  Then, build a simple LinkedListException class
 * that will be thrown in place of RuntimeExceptions whenever exceptional or error
 * situations occur.

 * @author Created by Navee on 11/14/16.
 */
public class LList {

    private Node head = null;
    private Node tail = null;

    /**
     * Adds a new node at the head of the list, puts the String data in the node.
     * @param data
     */
    public void insert(String data) {
        if (head == null) {
            head = new Node(data);
            tail =head;
        }else{
            Node temp = head;
            head = new Node(data);
            head.pNext = temp;
        }
    }

    /**
     * Adds a new node at the tail of the list. Puts the string data in the node.
     * @param data
     */
    public void addTail(String data) {
        if(tail == null) {
            tail = new Node(data);
        }else{
            tail.pNext = new Node(data);
            tail = tail.pNext;
        }
    }

    /**
     * Returns the head node.
     * @return
     */
    public Node getHead() {
        return head;
    }

    /**
     * Returns the tail node.
     * @return
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Returns the next node in the list after node.
     * Throws LinkedList Exception if node is null or node is a deleted node.
     * @param node
     * @return
     */
    public Node nextNode(Node node) throws LinkedListException{
        if (node == null ||node.pNext== null) {throw new LinkedListException("Invalid node.");}
        else {return node.pNext;}
    }

    /**
     * Removes the node at a specified index.
     * @param index
     */
    public void remove(int index) throws LinkedListException {
        if (index > numNodes() || index <0) {throw new LinkedListException("Invalid index.");}

        if(index==0){
            head=head.pNext;
        }else if(index == numNodes()-1){
            int internalIndex = 0;
            Node temp = head;
            Node prev = head;
            while (internalIndex < index) {//0<0
                internalIndex++;
                prev = temp;
                temp = temp.pNext;
            }
            prev.pNext=temp.pNext;
            tail = prev;
        }
        else {
            int internalIndex = 0;
            Node temp = head;
            Node prev = head;
            while (internalIndex < index) {//0<0
                internalIndex++;
                prev = temp;
                temp = temp.pNext;
            }
            prev.pNext=temp.pNext;
        }
    }

    /**
     * Removes deadNode from the list.
     * Throws LinkedListException if node is null or node is a deleted node.
     * @param deadNode
     */
    public void remove(Node deadNode) throws LinkedListException{
        if(numNodes()<=0){
            throw new LinkedListException("List is empty");
        }
        if(deadNode==null){
            throw new LinkedListException("deadNode is null");
        }
        Node current = head;
        Node prev = head;
        if(head.getData().equals(deadNode.getData())){
            head=head.pNext;
        }
        while (!current.getData().equals(deadNode.getData())){
            if(current.pNext==null){
                throw new LinkedListException("DeadNode not in list");
            }
            prev=current;
            current=current.pNext;
        }
        if(current.getData().equals(tail.getData())&&current.pNext==null){
            tail = prev;
        }
        prev.pNext=current.pNext;
        current.pNext=null;
    }

    /**
     * Adds a new node after the priorNode.
     * Throws LinkedList Exception if priorNode is deleted or null.
     * @param data
     * @param priorNode
     */
    public void addAfter(String data, Node priorNode) throws LinkedListException {
        Node temp = head;
        if(priorNode ==null){throw new LinkedListException("Priornode is null. ");}
        while(!temp.getData().equals(priorNode.getData())) {
            if(temp.pNext == null) {
                throw new LinkedListException("Priornode doesn't exist. ");
            }
            temp = temp.pNext;
        }
        Node newNode = new Node(data);
        newNode.pNext = temp.pNext;
        temp.pNext = newNode;
    }

    /**
     * Returns a count of the number of nodes in the list.
     * @return
     */
    public int numNodes() {
        Node temp = head;
        if(temp==null){
            return 0;
        }
        int count=1;
        while(temp.pNext!=null){
            temp=temp.pNext;
            count++;
        }
        return count;
    }

    /**
     * Returns the node at the specified index. Returns NULL if no node.
     * @param index
     * @return
     */
    public Node getNode(int index) {
        if(index > numNodes()||numNodes()==0||index<0){return null;}
        Node current = head;
        int count=0;
        while(current!=null){
            if(count==index){return current;}
            current=current.pNext;
            count++;
        }
        return null;
    }

    /**
     * Returns an array of strings where each element is one of the Data
     * elements in the node (i.e. the string value in the node).
     *
     * The elements in the array should be in the same order as the nodes
     * in the tree. Element[0] should be the head node.
     * @return
     */
    public String[] asArray() {
        Node current = head;
        String[] ret = new String[this.numNodes()];
        int i=0;
        while(current.pNext!=null){
            ret[i++]=current.getData();
        }
        return ret;
    }

    /**
     * The class Node is an inner class of the LList class that contains
     * the data, pNext, pPrev, etc.
     */
    public class Node {
        private Node pNext;
        private String data;

        /**
         * Constructor that takes String value.
         * @param value
         */
        private Node(String value) {
            data = value;
            pNext = null;
        }

        /**
         * The getData method will get data from a node.
         * @return
         */
        public String getData() {
            return data;
        }

        /**
         * Set the data from value.
         * @param value
         */
        public void setData(String value) {
            data = value;
        }
    }
}
