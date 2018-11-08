import java.util.Scanner;

/**
 * Created by Navee on 10/17/16.
 * Derved from the class Foundation.
 * When the data for SunBlockFoundation is entered, the user will enter a number other
 * than '1' or '2', which will not print to the screen bc it is UNKNOWN type.
 * Refer to Foundation class for more details.
 */
public class SunBlockFoundation extends Foundation {
    int spfFactor;

    public SunBlockFoundation() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter SPF factor: ");
        spfFactor = input.nextInt();
    }

    public String getAttributes() {
        String msg;
        msg = super.getAttributes();
        return "Sun Block " +msg+ "\nSPF Factor: "+spfFactor;
    }

    @Override
    public String toString() {
        return getAttributes();
    }
}
