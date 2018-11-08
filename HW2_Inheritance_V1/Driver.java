import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Navee on 10/13/16.
 * This is the Driver class, where the main is located.
 * It has an ArrayList to store products, which will then
 * print to screen once the user enters an 'x' or 'X' (using switch statements).
 */
public class Driver {
    static ArrayList <InventoryItem> products = new ArrayList<InventoryItem>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char in;
        while(true){
            System.out.println("Enter 'm' for mascara, 'f' for foundation, 's' for sun block, 'x' to exit");
            System.out.print("Entry?: ");
            in = input.nextLine().charAt(0);
            switch (in){
                case 'm':
                case 'M':{
                    products.add(new Mascara());
                    break;
                }case 'f':
                case 'F':{
                    products.add(new Foundation());
                    break;
                }case 's':
                case 'S':{
                    products.add(new SunBlockFoundation());
                    break;
                }
                case 'x':
                case 'X':{
                    break;
                }
                default:{
                    break;
                }
            }
            if(in == 'x' || in == 'X'){
                break;
            }
        }
        printInventory();
    }


    /*This method will print the inventory and the number of entries user inputs.
    * The loop checks to see if the product array is empty; if not, then it gets the count.
    * The count is saved from InventoryItem to local varies entries.
    */
    public static void printInventory(){
        int entries=0;
        if(!products.isEmpty()){
            entries=products.get(0).getCount();
        }
        System.out.println("\n\nThere are " + entries + " entries in the catalog: " );
        System.out.println("--------------------\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
            System.out.println("\n\n\n--------------------\n");
        }
    }
}
