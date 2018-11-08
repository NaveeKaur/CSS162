/**
 * The Bill class represents an outstanding or paid bill.
 * The class should contain the amount of the bill as a Money object,
 * the due date of the bill (a Date object) and a Date object to track
 * the date paid (null if not yet paid).
 * When paying the bill, the date isn’t past the due date.
 *
 * Created by Navee on 10/25/16.
 */
public class Bill {

    private Money amount;
    private Date dueDate;
    private Date paidDate=null;
    private String company;

    //constructor
    public Bill(Money amount, Date dueDate, String originator) {
        setAmount(amount);
        setDueDate(dueDate);
        setOriginator(originator);
    }

    //copy constructor
    public Bill(Bill toCopy) {
        amount = new Money(toCopy.getAmount());
        dueDate = new Date(toCopy.getDueDate());
        company = new String(toCopy.getOriginator());
    }
    //Getter
    public Money getAmount(){
        return new Money(amount);
    }

    //Getter
    public String getOriginator(){
        return new String(company);
    }

    //Getter
    public Date getDueDate() {
        return new Date(dueDate);
    }


    /**
     * SETTER
     * Change the amount owed.
     * If already paid returns false and does not change the amount owed.
     * Else changes the amount and returns true.
     * @param amt
     */
    public boolean setAmount(Money amt){
        if(isPaid()) {
            return false;
        }
        amount = new Money(amt);
        return true;
    }
    //Setter
    public void setOriginator(String newCompany){
        company = new String(newCompany);
    }

    //Setter

    /**
     * Resets the due date – If the bill is already paid, this call fails and returns false.
     * Else it resets the due date and returns true.
     * @param newDate
     */
    public boolean setDueDate(Date newDate) {
        if(isPaid()) {
            return false;
        }
        dueDate = new Date(newDate);
        return true;
    }

    /**
     * if datePaid is after the dueDate, the call does not update anything and returns false.
     * Else updates the paidDate and returns true
     If already paid, we will attempt to change the paid date.
     * @param newPayDate the date when the bill was paid for.
     */
    public boolean setPaid(Date newPayDate) {
        if (newPayDate.isAfter(dueDate)) {
            return false;
        }
        else {
            this.paidDate = new Date (newPayDate);
            return true;
        }
    }

    //To check whether the bill is paid or not
    public boolean isPaid(){
        return(paidDate != null);
    }


    /**
     * Build a string that reports the amount, when due, to whom, if paid, and if paid the date paid
     * @return
     */
    public String toString(){
        String retVal = "";
        if( !isPaid()){ //if it isn't paid
            retVal = "Amount due: " + this.getAmount() + "\nDue date: " + this.getDueDate() + "\nName: " + this.getOriginator() + "\nPayment is pending. ";
        }else{
            retVal = "Amount due: " + this.getAmount() + "\nDue date: " + this.getDueDate() + "\nName: " + this.getOriginator()+ "Payment submitted on: " + this.paidDate;
        }
        return retVal;
    }

    /**
     *Equality is defined as each field having the same value.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (amount != null ? !amount.equals(bill.amount) : bill.amount != null) return false;
        if (dueDate != null ? !dueDate.equals(bill.dueDate) : bill.dueDate != null) return false;
        if (paidDate != null ? !paidDate.equals(bill.paidDate) : bill.paidDate != null) return false;
        return company != null ? company.equals(bill.company) : bill.company == null;

    }

}
