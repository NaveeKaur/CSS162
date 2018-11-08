/**
 * The Money class is used to track a USD amount consisting of two integers to
 * manage dollars and cents.
 * All amounts will be positive or 0.  We should never return any cents GT 99.
 *
 *  Created by Navee on 10/22/16.
 */
public class Money {

    private int dollars,cents;
    //constructor that sets the dollar amount and sets cents to 0.
    public Money(int dol) {
        setDollars(dol);
    }

    //constructor that initializes dollars and cents.
    public Money(int dol, int cent) {
        setDollars(dol);
        setCents(cent);
    }

    //copy constructor
    public Money(Money o){
        setMoney(o.getDollars(), o.getCents());
    }

    public void setDollars(int dol) {
        this.dollars = dol;
        if (dollars < 0) {
            throw new IllegalArgumentException("Error: invalid amount.");
        }
    }

    public void setCents(int cent) {
        this.cents = cent;
        if (cents < 0) {
            throw new IllegalArgumentException("Error: invalid amount.");
        }
        while (cents > 99) {
            dollars ++;
            cents = cents - 100;
        }
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }


    public void setMoney(int d, int c) {
        setDollars(d);
        setCents(c);
    }

    public double getMoney() {
        return (double)dollars+ (double)cents/(double)100;
    }

    /**
     * If the user enters in an amount LT 0, you will throw an IllegalArgumentException
     * @param d
     */
    public void add(int d) {
        if(d<0){
            throw new IllegalArgumentException("Dollar is less than 0");
        }
        this.dollars += d;
    }


    /**
     * Using the add method from this class i reuse that to add the dollars and write code to add cents.
     * this allows modularity
     * @param d
     * @param c
     */
    public void add(int d, int c){
        add(d);
        if(c<0){
            throw new IllegalArgumentException("Cents are less than 0");
        }
        this.cents += c;

        while (cents >99) {
            dollars ++;
            cents =- 100;
        }
    }


    public void add(Money other) {
        int dol = other.getDollars();
        int cent = other.getCents();
        add(dol, cent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (dollars != money.dollars) return false;
        return cents == money.cents;

    }

    @Override
    public String toString() {
        String theCents ="";
        if(cents< 10){
            theCents = "0"+cents;//
        }
        else{
            theCents = ""+cents;
        }

        return "$" + this.getDollars() + "." +theCents;
    }
}
