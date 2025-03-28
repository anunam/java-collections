package listinterface;
import java.util.*;

public class FindNthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move the fast pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null; // If N is greater than list size, return null
            fast.next();
        }

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next(); // Slow is now at the Nth element from the end
    }

    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int N = 2;
        System.out.println("Nth from End: " + findNthFromEnd(letters, N)); // Output: D
    }
}
