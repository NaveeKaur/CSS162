/**
 * The date class represents a date in our world, w/o using any built in date classes in this assignment.
 * This is different from the Savitch book.
 * Created by Navee on 10/22/16.
 */
public class Date {

    private int month, day, year;

    public Date(int m, int d, int y) {
        setMonth(m);
        setDay(d);
        setYear(y);
    }

    //copy constructor
    public Date(Date other) {
        month = other.getMonth();
        day = other.getDay();
        year = other.getYear();
    }

    public void setMonth(int m) {
        this.month = m;
        if ((month <=0) || (month > 12)) {
            throw new IllegalArgumentException("Error: invalid month");
        }
    }

    public void setDay(int d) {
        this.day = d;
        if ((day <= 0) || (day > 31)) {
            throw new IllegalArgumentException("Error: invalid day");
        }
    }

    public void setYear(int y) {
        this.year = y;
        if (year < 0) {
            throw new IllegalArgumentException("Error: invalid year");
        }
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public boolean isAfter(Date compareTo) {
        if(compareTo.getYear() >= this.getYear()) {
            if(compareTo.getYear() == this.getYear()) {
                if(compareTo.getMonth() >= this.getMonth()) {
                    if(compareTo.getMonth() == this.getMonth()) {
                        if(compareTo.getDay() > this.getDay()) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object date) {
        if(this == date){
            return true;
        }

        if(!(date instanceof Date)) {
            return false;
        }
        Date myDate = (Date)date;
        if(this.month != myDate.getMonth()) {
            return false;
        }

        if(this.day != myDate.getDay()) {
            return false;
        }

        if(this.year != myDate.getYear()) {
            return false;
        }

        return true;
    }

    public String toString() {
        String retval = "";
        if(month <10) {
            retval += "0" +month+"/";
        }
        else retval += month+"/";

        if(day <10) {
            retval += "0" +day+"/";
        }
        else retval += day+"/";

        return retval + year;
    }
}
