import java.util.Scanner;

/**
 * The driver program should prompt the user for the max number of
 * files to look for, the directory to start in, and the filename.
 *
 * The driver should then print out the list of found files with
 * the full path name to the file (including the starting directory).
 *
 * In the event of an exception being thrown, the driver should catch
 * it and provide an appropriate message to the user.
 *
 * This works on linux computers. 
 *
 * Created by Navee on 11/10/16.
 */
public class Driver {

    static final int MAX_NUMBER_OF_FILES_TO_FIND =100;
    static Scanner keyboard=new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }
    public static void run(){
        System.out.print("Enter the path to search please: ");
        String pathToSearch=keyboard.nextLine();
        System.out.print("Enter the target file please: ");
        String targetFile =keyboard.nextLine();
        System.out.print("Enter the max number of files to search please: ");
        int max = keyboard.nextInt();
        FindFile finder = new FindFile(max);
        try {
            finder.directorySearch(targetFile,pathToSearch);
        }catch (IllegalArgumentException e) {
            System.err.println("Directory name invalid!");
            run();
        }
        System.out.println("Number of files found: " + finder.getCount());
        System.out.println(finder.toString());
    }
}

