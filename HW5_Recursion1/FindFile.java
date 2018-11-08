import java.io.File;
/**
 *
 *
 * Created by Navee on 11/08/16.
 */
public class FindFile {

    int maxFiles, count;
    String[] files;

    public FindFile(int maxFiles) {
        this.maxFiles = maxFiles;
    }

    /**
     * The parameters are the target file name to look for and
     * the directory to start in. Should throw an
     * IllegalArgumentException if the path passed in the starting
     * directory is not a valid directory.
     *
     * Create a File object, list files in current directory as
     * Strings, and check whether it is a directory (recursive call).
     */
    public void directorySearch(String target, String dirName) throws IllegalArgumentException {
        File f = new File(dirName);
        String[] fileList = f.list();

        for (int i = 0; i < fileList.length; i++) {
            File aFile = new File(dirName + "\\" + fileList[i]);

            if (aFile.isDirectory()) {
                directorySearch(target, aFile.getName());
            }
            else if(target.equals(aFile.getName())) {
                files[count] = aFile.getParentFile().getName();
                count++;
            }
        }
    }

    /**
     * This accessor returns the number of matching files found
     */
    public int getCount() {
        return count;
    }

    /**
     * This getter returns the array of file locations, up to
     * maxFiles in size.
     */
    public String[] getFiles() {
        return files;
    }

}
