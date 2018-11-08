import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Driver for Fractions V2 Assignment. It's purpose is to read the file (in main), split fractions, and to get them in the ArrayList.
 * First assignment with ArrayList -- reference.
 * Created by Navee on 10/2/16.
 * HW1 FractionsV2
 */
public class Driver {
    static Scanner input = null;
    static ArrayList<Fraction> fractionsArray = new ArrayList<Fraction>();
    static ArrayList<FractionCounter> fracCounterArray = new ArrayList<FractionCounter>(); //ArrayList! correct syntax; different from notes.
    public static void main(String[] args) {
        getFile(); //Step 1

    }
    public static void getFile(){ //read in file
        try {
            input = new Scanner(new FileInputStream("fractions.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR : FILE NOT FOUND!");;
        }
        while(input.hasNextLine()){
            String temp = input.nextLine(); // 6/2 -> split "/" -> returns an array of length of two array[0] is the first part array [1] is the second
            int num = Integer.parseInt(temp.split("/")[0]); // Integer.parseInt  turns string into a int
            int denom = Integer.parseInt(temp.split("/")[1]); //split input into num and denom and store in different index of array
            Fraction a = new Fraction(num,denom);
            fractionsArray.add(a);
        }
        for (int i = 0; i < fractionsArray.size(); i++) { //loop through to see if fraction is already in the list. If so, it adds it. 
            // if in counterList then increment;
            Fraction temp = fractionsArray.get(i);
            if(fracCounterArray.size()==0){
                fracCounterArray.add(new FractionCounter(temp));
            }else{
            for (int j = 0; j < fracCounterArray.size(); j++) {
                FractionCounter a = fracCounterArray.get(j);
                if(a.compareFraction(temp)){ //true : incrementCount
                    fracCounterArray.get(j).incrementCount();
                    break;
                }else if(j+1 == fracCounterArray.size())
                {
                    fracCounterArray.add(new FractionCounter(temp));
                    break;
                }
            }
            // if not in counterList then add;
            }
        }

        for (int i = 0; i < fracCounterArray.size(); i++) {
            System.out.println(fracCounterArray.get(i).toString());
        }
        //get the strings and add them to the fraction arraylist
    }

}
