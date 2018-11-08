
/**
 * The Fraction class has bulk of the code, although it is fairly simple. This class sets the constructors, getters, and setters.
 * Also includes overloading and overriding to initialize and compare data.
 * Created by Navee on 10/4/16.
 */
public class Fraction {
    private int num; //numerator
    private int denom; //denominator
    public Fraction() {} //default constructor
    public Fraction(int n, int d) { //constructor that initializes data
        int gcd = gcd(n,d);
        if(d == 0|| n ==0) {//this portion helps covers 0/1 fractions
            this.num=0;
            this.denom=0;
        }
        this.num = n/gcd;
        this.denom = d/gcd;
    }

    public int getNum() {
        return num;
    } //getters and setters for numerators and denominators

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    public String toString() {
        return num + "/" + denom;
    }

    @Override
    public boolean equals(Object o) { //overriding: compares "this" to "other"
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (num != fraction.num) {
            return false;
        }
        return denom == fraction.denom;
    }

    public int gcd(int a, int b){ //to find the greatest common divisor
        a = Math.abs(a); //not sure if we are allowed to use these in 162 yet, but this takes care of negative numbers.
        b = Math.abs(b);
        while(b > 0)
        {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

}