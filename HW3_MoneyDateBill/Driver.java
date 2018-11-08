/**
 * A main is not necessary in this assignment, but I wanted one.
 *
 * Created by Navee on 10/27/16.
 */
public class Driver {

    public static void main(String[]args){
        System.out.println("\tStart");
        JUnitTestFramework test = new JUnitTestFramework();
        test.setUp();
        test.testMoneytDolCentConstructor();
        test.testMoneyInvalidInput();
        test.testBillConstructorPrivacyLeak();
        test.testDateToString();
        test.tearDown();
    }

}
