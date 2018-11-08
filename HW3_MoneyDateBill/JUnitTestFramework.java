import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JUnitTestFramework.
 * This class is intended to demonstrate how to do jUnit testing on a suite
 * of classes.
 *
 * @author  JohnChenault)
 * @version Fall 2016
 */
public class JUnitTestFramework
{
    /**
     * Default constructor for test class TestFramework
     */
    public JUnitTestFramework()
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


    // Test the Money object constructor
    // Simply set the values in the constructor, and then
    // get them to make sure they are correct.
    @Test
    public void testMoneytDolCentConstructor()
    {
        Money m = new Money(5, 120);
        System.out.println(m.toString());
        assertEquals( 6, m.getDollars());
        assertEquals( 20, m.getCents());
    }

    @Test
    public void testMoneyInvalidInput()
    {
        try {
            Money m = new Money(-1,0);
            // If we get here we did not throw exception. If an assertTrue is false, code doesn't run.
            assertTrue( false);
        }
        catch ( IllegalArgumentException e )
        {
            // Caught the illegal argument
            assertTrue(true);
        }
    }

    // Test the date toString method - paying attention to
    // single digit month/day
    //assertEquals -> both the values have to be equal.
    @Test
    public void testDateToString()
    {
        Date date1 = new Date(1, 2, 2020);
        //what iscalled //constructor type? Date
        assertEquals("01/02/2020", date1.toString());
        Date date2 = new Date(11, 12, 2021);
        assertEquals("11/12/2021", date2.toString());
    }


    // Test the Bill constructor for privacy leak in the Date field.
    @Test
    public void testBillConstructorPrivacyLeak()
    {
        Date date1 = new Date( 1, 1, 2020);
        Money money1 = new Money( 10);
        Bill myBill = new Bill( money1, date1, "sam");

        date1.setYear( 2021);
        money1.setMoney( 5, 10);

        // Now get values and make sure they have not changed
        assertTrue( myBill.getAmount().getCents() == 0);
        assertTrue( myBill.getDueDate().getYear() == 2020);
    }


}

