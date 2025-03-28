package setinterface;
import java.util.Set;
import java.util.HashSet;

public class SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // Copy set1
        Set<Integer> intersection = new HashSet<>(set1);

        result.addAll(set2); // Union of both sets
        intersection.retainAll(set2); // Intersection of both sets

        result.removeAll(intersection); // Remove common elements
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
        // Output: {1, 2, 4, 5}
    }
}
