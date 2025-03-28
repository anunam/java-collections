package setinterface;
import java.util.Set;
import java.util.HashSet;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // Copy set1
        result.addAll(set2); // Add all elements of set2
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // Copy set1
        result.retainAll(set2); // Keep only elements also in set2
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

        System.out.println("Union: " + union(set1, set2));           // Output: {1, 2, 3, 4, 5}
        System.out.println("Intersection: " + intersection(set1, set2)); // Output: {3}
    }
}
