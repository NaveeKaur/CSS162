
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LListTest
{
    /**
     * Default constructor for test class LListTest
     */
    public LListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /*
     * Things to test:
     * General operation.  Add three items.  Use NextNode / to check all there
     * Get head and getTail.  Test on empty, and one element lists. 
     * Index search.  Add five items.  Get 0, 1,4,5
     * ndex search.  NEgative index. 
     * Add at tail.  add three.  Add one at tail.  Check for valid values
     * numNodes .  Check on empty list.  Add one.  Add two more.
     * addAfter  Node
     * delete by node where first, last, middle.  Verify teh back chaining by deleting a pair
     * *Delete by index.  Same drll as node. 
     *  Next node with null node. IE delete a node - then delete it again. Throws exception
     *  remove a removed node and look for exception.
     *  TEst for null node on all calls. 
     * String. 
     */

    // General operation.  Add three items.  Use next node to check that they are there in order. 
    @Test
    public void testGeneralOperation() throws LinkedListException
    {
        LList list = new LList();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        LList.Node node = list.getHead();
        assertTrue(node.getData().equals("c"));
        node = list.nextNode(node);
        assertTrue(node.getData().equals("b"));
        node = list.nextNode(node);
        assertTrue(node.getData().equals("a"));
//        node = list.nextNode(node);
//        assertTrue( node == null);
    }

    // TEst get head and get tail on empty, single , and multiple entries. 
    @Test
    public void testgetHeadTail()
    {
        LList list = new LList();
        LList.Node node = list.getHead();
        assertTrue(node == null);
        node = list.getTail();
        assertTrue(node == null);

        // Now add some. 
        list.insert("a");
        list.insert("b");
        list.insert("c");
        node = list.getHead();
        assertTrue(node.getData().equals("c"));

        node = list.getTail();
        assertTrue(node.getData().equals("a"));
        System.out.println("Passed testgetHeadTail");
    }
    // Test for index search
    @Test
    public void indexTest()
    {
        LList list = new LList();
        LList.Node node;

        node = list.getNode(0);
        assertTrue(node == null);

        node = list.getNode(2);
        assertTrue(node == null);

        // Now add some. 
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");

        node = list.getNode(0);
        assertTrue(node.getData().equals("d"));

        node = list.getNode(1);
        assertTrue(node.getData().equals("c"));

        node = list.getNode(2);
        assertTrue(node.getData().equals("b"));

        node = list.getNode(3);
        assertTrue(node.getData().equals("a"));

        node = list.getNode(4);
        assertTrue(node == null);
    }
    // TEst for a negative index. 
    @Test
    public void testNegIndex()
    {
        LList list = new LList();
        LList.Node node;

        node = list.getNode(-1);
        assertTrue( node == null);

        // Now add some. 
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");

        node = list.getNode(-1);
        assertTrue( node == null);
    }

    // TEst adding to Tail. 
    @Test
    public void addTail() throws LinkedListException
    {
        LList list = new LList();
        LList.Node node;

        // Now add some. 
        list.insert("a");
        list.insert("b");
        list.addTail("c");
        list.addTail("d");

        node = list.getHead();
        assertTrue(node.getData().equals("b"));
        node = list.nextNode(node);
        assertTrue(node.getData().equals("a"));
        node = list.nextNode(node);
        assertTrue(node.getData().equals("c"));
        node = list.nextNode(node);
        assertTrue(node.getData().equals("d"));
        //node = list.nextNode(node);
        //assertTrue(node == null);
    }

    // TEst numNodes on empty, then fuller list
    @Test
    public void testNumNodes()
    {   
        LList list = new LList();
        LList.Node node;

        assertTrue( list.numNodes() == 0);
        list.insert("a");
        assertTrue( list.numNodes() == 1);
        list.insert("b");
        assertTrue( list.numNodes() == 2);
        list.insert("c");
        assertTrue( list.numNodes() == 3);

    }

    // TEst addAfter on a node
    // Note this suite should NOT throw a LinkedListException 
    // 
    @Test
    public void testAddAfterNode() throws LinkedListException
    {

        LList list = new LList();
        LList.Node node;

        // Initialize the list
        list.insert("a");
        list.insert("b");
        list.insert("c");

        // Order is c b a
        // We start by adding after the first node.
        node  = list.getNode(0);

        list.addAfter( "X", node);
        // Order should now be c X b a
        assertTrue( list.getNode(0).getData().equals("c"));
        assertTrue( list.getNode(1).getData().equals("X"));
        assertTrue( list.getNode(2).getData().equals("b"));
        assertTrue( list.getNode(3).getData().equals("a"));

        node = list.getNode(3);
        list.addAfter("Y", node);
        assertTrue( list.getNode(0).getData().equals("c"));
        assertTrue( list.getNode(1).getData().equals("X"));
        assertTrue( list.getNode(2).getData().equals("b"));
        assertTrue( list.getNode(3).getData().equals("a"));
        assertTrue( list.getNode(4).getData().equals("Y"));

    }

    // TEst deletion of node by Node .
    @Test
    public   void deleteByIndex()
    {
        LList list = makeaToeList();
        LList.Node node;

        // Order is "a b c d e 
        // Start by deletin two in the middle
        try {
            list.remove(2);
            list.remove(2);
            // List is not a b e
            assertTrue( list.getNode(0).getData().equals("a"));
            assertTrue( list.getNode(1).getData().equals("b"));
            assertTrue( list.getNode(2).getData().equals("e"));

            // Now delete the tail.
            list.remove( 2);
            assertTrue( list.numNodes() == 2);
            assertTrue( list.getTail().getData().equals("b"));
            assertTrue( list.getNode(0).getData().equals("a"));
            assertTrue( list.getNode(1).getData().equals("b"));

            // Delete the last two.
            list.remove(0);
            list.remove(0);

            // Add one back jsut to make sure things are not horrible.
            assertTrue( list.numNodes() == 0);
            list.insert("X");
            assertTrue( list.getHead().getData().equals("X"));
            assertTrue( list.getTail().getData().equals("X"));
            assertTrue( list.getNode(0).getData().equals("X"));
        } catch (LinkedListException e) {
            e.printStackTrace();
        }

    }
    // TEst deleting by node.  Same scheme as by index
    @Test
    public void deleteByNode()    throws LinkedListException
    {
        LList list = makeaToeList();
        LList.Node node;

        // Order is "a b c d e 
        // Start by deletin two in the middle
        list.remove(list.getNode(2));
        list.remove(list.getNode(2));
        // List is not a b e 
        assertTrue( list.getNode(0).getData().equals("a"));
        assertTrue( list.getNode(1).getData().equals("b"));
        assertTrue( list.getNode(2).getData().equals("e"));

        // Now delete the tail. 
        list.remove( list.getNode(2));
        assertTrue( list.numNodes() == 2);
        assertTrue( list.getTail().getData().equals("b"));
        assertTrue( list.getNode(0).getData().equals("a"));
        assertTrue( list.getNode(1).getData().equals("b"));

        // Delete the last two.
        list.remove(list.getNode(0));
        list.remove(list.getNode(0));

        // Add one back jsut to make sure things are not horrible. 
        assertTrue( list.numNodes() == 0);
        list.insert("X");
        assertTrue( list.getHead().getData().equals("X"));
        assertTrue( list.getTail().getData().equals("X"));
        assertTrue( list.getNode(0).getData().equals("X"));     

    }

    // TEst doing a next node with a deleted node. Should throw exception
    @Test
    public void nextOnDeletedNode()  throws LinkedListException
    {
        LList list = makeaToeList();
        LList.Node node;
        // Initialize the list

        node = list.getNode(3);
        list.remove(node);
        // First do one in the middle. 
        try {
            LList.Node someNode = list.nextNode(node);
            // We should not get here. 
            assertTrue(false);
        }
        catch ( LinkedListException ex) {
            // If we get here we are happy as it throw the exception
        }

        // Now do the last one.
        node = list.getTail();
        list.remove(node);
        try {
            LList.Node someNode = list.nextNode(node);
            // We should not get here. 
            assertTrue(false);
        }
        catch ( LinkedListException ex) {
            // If we get here we are happy as it throw the exception
        }

        // Not try the last one
        node = list.getTail();
        list.remove(node);
        try {
            LList.Node someNode = list.nextNode(node);
            // We should not get here. 
            assertTrue(false);
        }
        catch ( LinkedListException ex) {
            // If we get here we are happy as it throw the exception
        }    
    }

    // Delete a node - then try to delete it again.  Should throw exception
    @Test
    public void doubleDelete() 
    {
        LList list = makeaToeList();
        LList.Node node;
        // Initialize the list

        node = list.getNode(3);

        // this next should throw an exception
        try {
            list.remove(node);
            list.remove(node);
            // If I get here I am hosed
            assertTrue(false);
        }
        catch ( LinkedListException ex ) {
            // The happy path. 
        }
    }

    // TEst for null nodes. 
    @Test
    public void testNullNodes()
    {
        LList list = new LList();

        LList.Node nullNode  = null;
        // First test on list with no elements.

        try {
            list.nextNode(nullNode);
            assertTrue(false);
        }
        catch ( LinkedListException ex)
        {
            // happy case
        }
        try {
            list.remove( nullNode);
            assertTrue(false);
        }
        catch ( LinkedListException ex)
        {
            // happy case
        }
        try {
            list.addAfter("X", nullNode);
            assertTrue(false);
        }
        catch ( LinkedListException ex)
        {
            // happy case
        }
        // Not init the list and run it again. 
        list = makeaToeList();

        try {
            list.nextNode(nullNode);
            assertTrue(false);
        }
        catch ( LinkedListException ex)
        {
            // happy case
        }
        try {
            list.remove( nullNode);
            assertTrue(false);
        }
        catch ( LinkedListException ex)
        {
            // happy case
        }
        try {
            list.addAfter("X", nullNode);
            assertTrue(false);
        }
        catch ( LinkedListException ex)
        {
            // happy case
        }

    }
    
    // TEst the string printing
    @Test
    public void testasArray()
    {
        LList list = new LList();

        String[] emptyList = list.asArray();
        assertTrue( emptyList.length == 0);

        list = makeaToeList();
        String[] fullList = list.asArray();
        assertTrue(fullList.length == 5);

        assertTrue( fullList[0].equals("a"));
        assertTrue( fullList[1].equals("b"));
        assertTrue( fullList[2].equals("c"));
        assertTrue( fullList[3].equals("d"));
        assertTrue( fullList[4].equals("e"));
    }

        
    /////////////////////////////////////////////////////////////////////
    private LList makeaToeList()
    {

        LList list = new LList();
        // Initialize the list
        list.insert("e");
        list.insert("d");
        list.insert("c");
        list.insert("b");
        list.insert("a");
        return list;
    }

    
}
