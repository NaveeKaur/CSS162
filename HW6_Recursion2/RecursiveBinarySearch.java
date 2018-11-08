/**
 * In the BinarySearch class, do a recursive binary search.
 * Set MidIndex halfway between LowIndex and HighIndex while LowIndex is less than
 * or equal to HighIndex.
 *
 * If the target word matches the word at MidIndex, return MidIndex (first case).
 * If the target word is before the word at MidIndex, then set HighIndex to MidIndex-1.
 * If the target word is after the word at MidIndex, then set the LowIndex to MidIndex+1.
 *
 * If the target word was not found, throw an ItemNotFoundException.
 *
 * @author Created by Navee on 11/15/16.
 */
public class RecursiveBinarySearch extends SearchAlgorithm {


    /**
     * This is a 'helper' method for searchHelper below.
     * @param words
     * @param target
     * @return
     * @throws ItemNotFoundException
     */
    public int search(String[] words, String target) throws ItemNotFoundException {
        try{
            return searchHelper(words, target, 0, words.length-1);
        }catch (ItemNotFoundException e){
            throw new ItemNotFoundException(target + " not found.");
        }
    }

    /**
     * This method does the recursive searching as needed for this class.
     * @param words
     * @param target
     * @param lowIndex
     * @param highIndex
     * @return
     * @throws ItemNotFoundException
     */
    private int searchHelper(String[] words, String target, int lowIndex, int highIndex) throws ItemNotFoundException {

        if (lowIndex > highIndex) {
            throw new ItemNotFoundException();
        }
        int midIndex = (lowIndex + highIndex)/2;

        if(words[midIndex].equals(target)) {
            incrementCount();
            return midIndex;
        }
        else if(words[midIndex].compareTo(target) < 0) {
            incrementCount();
            return searchHelper(words, target, midIndex+1, highIndex);
        }
        else {
            incrementCount();
            return searchHelper(words, target, lowIndex, midIndex - 1);
        }
    }

}
