/**
 * In the BinarySearch class, do an iterative binary search.
 * Set MidIndex halfway between LowIndex and HighIndex while LowIndex is less than
 * or equal to HighIndex.
 *
 * If the target word matches the word at MidIndex, return MidIndex (first case).
 * If the target word is before the word at MidIndex, then set HighIndex to MidIndex-1.
 * If the target word is after the word at MidIndex, then set the LowIndex to MidIndex+1.
 *
 * If the target word was not found, throw an ItemNotFoundException.
 *
 * Created by Navee on 11/14/16.
 */
public class BinarySearch extends SearchAlgorithm {

    public int search(String[] arraySize, String target) throws ItemNotFoundException {
        int lowIndex = 0, highIndex = arraySize.length -1;

        while (lowIndex <= highIndex) {
            int midIndex = ((lowIndex + highIndex) / 2);

            if (target.compareTo(arraySize[midIndex]) < 0) {
                incrementCount();
                highIndex = midIndex - 1;
            } else if (target.compareTo(arraySize[midIndex]) > 0) {
                incrementCount();
                lowIndex = midIndex + 1;
            } else {
                incrementCount();
                return midIndex;
            }
        }
        throw new ItemNotFoundException(target + " not found.");
    }
}
