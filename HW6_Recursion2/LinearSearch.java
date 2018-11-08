/**
 * This class should loop through the words from beginning to end, comparing the current
 * string with the target string at each step.
 *
 * The utility function incrementCount() willl be called each time a comparison is made
 * (ie, each time in the loop). Thus, when the search is complete, there is an accurate
 * count of the comparisons required by the search strategy.
 *
 * @author Created by Navee on 11/13/16.
 */
public class LinearSearch extends SearchAlgorithm {

    public int search(String[] words, String target) throws ItemNotFoundException {

        int size = words.length;
        for(int i = 0; i <size; i++) {
            incrementCount();

            if(words[i].equals(target)) {
                return i;
            }
        }
        throw new ItemNotFoundException(target + " not found.");
    }
}
