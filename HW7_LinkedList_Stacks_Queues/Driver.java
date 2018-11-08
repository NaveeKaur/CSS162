/**
 * Driver class to test LList, Stack, and Queue classes
 * @author Created by Navee on 11/19/16.
 */
public class Driver {
    public static void main(String[] args){
        LListTest a = new LListTest();
        a.setUp();
        try {
            a.testGeneralOperation();
            a.testgetHeadTail();
            a.indexTest();
            a.testNegIndex();
            a.addTail();
            a.testNullNodes();
            a.testNumNodes();
            a.testAddAfterNode();
            a.deleteByIndex();
            a.deleteByNode();
            a.doubleDelete();
            a.nextOnDeletedNode();
        } catch (LinkedListException e) {
            e.printStackTrace();
        }
        System.out.println("PASSES ALL LIST TESTS");

        StackTest b = new StackTest();
        b.setUp();
        b.testEmptyStack();
        b.basicFunctionality();
        System.out.println("PASSES ALL STACK TESTS");

        QueueTest c = new QueueTest();
        c.setUp();
        c.testEmpty();
        c.basicFunctionality();
        System.out.println("PASSES ALL QUEUE TESTS");

    }
}
