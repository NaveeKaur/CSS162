import java.util.Iterator;

/**
 * Driver for Set.java
 */
public class TestSet {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        SetInterface<Person> a = new Set<>();
        Person one = new Person(1,"one");
        Person two = new Person(2,"two");
        Person three = null;
        Person four = new Person(4,"four");
        a.add(three); // does not get added.
        a.add(two);
        a.add(two);
        a.add(one);
        System.out.println("Testing contains: "+a.contains(one));
        //a had 1,2,3 but three is null
        System.out.println("The size of a is: "+a.size());
        SetInterface<Person> b = new Set<>();
        b.add(two);
        b.add(four);
        //b has 2,4
        SetInterface<Person> intersection = b.makeIntersection(a);
        Iterator<Person> inter  = intersection.getIterator();
        System.out.println("Testing Intersection; should give what both have and not the unique:");
        printIterator(inter);

        SetInterface<Person> union = b.makeUnion(a);
        System.out.println("Testing union; should give you the combination of all:");
        printIterator(union.getIterator());

        System.out.println("Finished!");
    }

    /**
     * Prints the iterator
     * @param inter
     */
    private static void printIterator(Iterator<Person> inter) {
        int i =0;
        while (inter.hasNext()){
            System.out.println("i: " + i +", " +inter.next().toString());
        }
    }

}
