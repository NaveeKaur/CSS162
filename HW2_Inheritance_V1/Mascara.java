import java.util.Scanner;

/**
 * Created by Navee on 10/12/16.
 * Derived from InventoryItem; represents different types of Mascara.
 * There are two attributes: string colour and boolean waterproof.
 * The getAttributes methods takes these attributes and toString returns them in human lang.
 */
public class Mascara extends InventoryItem {
    String color;
    boolean waterproof =false;
    public Mascara() {

        super();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter color name: ");
        color = input.nextLine();
        System.out.print("Is it waterproof? (Y = yes. No = no): ");
        char bool = input.nextLine().charAt(0);
        if ((bool == 'y') || (bool == 'Y')) {
            waterproof =true;
        }
    }
    public String getAttributes() {
        String water;
        if (waterproof){
            water="YES";
        }else{
            water = "NO";
        }
        String msg;
        msg = super.getAttributes();
        return "Mascara\nColor: " + color +"\nWaterproof: "+ water + "\nInventory ID: " +msg;
    }

    @Override
    public String toString() {
        return getAttributes();
    }
}


