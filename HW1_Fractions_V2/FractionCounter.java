/**
 * The FractionCounter class increments the count and returns it.
 * Created by Navee on 10/3/16.
 * HW1 FractionsV2
 */
public class FractionCounter {
    int count=1; //count of number of fractions seen
    Fraction frac; //type Fractions from prev class

    public FractionCounter() {}

    public FractionCounter(Fraction newFrac) {
        this.frac = newFrac;
    } //constructor
    public boolean compareFraction(Fraction newFrac) { //"used to see if the newFraction passed into this function is the same as the Fraction we’re storing, and if so returns true (otherwise, returns false)."
        return this.frac.equals(newFrac);
    }
    public void incrementCount() {
        count++;
    } //increments count
    public String toString() {
        return this.frac.toString() + " has a count of " + count;
    } //prints out fraction and its count
}
