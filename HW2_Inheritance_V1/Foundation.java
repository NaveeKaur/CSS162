import java.util.Scanner;

/**
 * Created by Navee on 10/13/16.
 * Derived from InventoryItem – represents different types of foundations.
 * There are two attributes: string colour and enum that tells us if it is LIQUID, POWDER, or UNKNOWN.
 * If the user enters something other than powder (1) or liquid(2), then it doesn't print to screen.
 * getAttributes & toString similar to Mascara class. Refer to Mascara class for more info.
 */
public class Foundation extends InventoryItem {
    String color;
    Type base;
    public enum Type {
        LIQUID, POWDER, UNKNOWN;
    }

    public Foundation(){
        super();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter color name: ");
        color = input.next();
        System.out.print("Enter 1 for powder, 2 for liquid: ");
        int baseType = input.nextInt();
        if (baseType ==1) {
            base = Type.POWDER;
        }else if(baseType ==2){
            base =Type.LIQUID;
        }else{
            base=Type.UNKNOWN;
        }
    }

    //If the user enters something other than powder (1) or liquid(2), then it doesn't print to screen.
    public String getAttributes() {
        String msg;
        msg = super.getAttributes();
        String baseStr="";
        if(base !=Type.UNKNOWN){
            baseStr ="\nBase is " + base.toString();
        }
        return "Foundation\n\nColor: " + color +baseStr+ "\nInventory ID: " +msg;
    }
}
