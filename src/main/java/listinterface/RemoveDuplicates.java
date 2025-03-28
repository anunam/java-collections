package listinterface;
import java.util.*;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (seen.add(item)) { // Add to result only if not seen before
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }
}
