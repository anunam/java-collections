package listinterface;
import java.util.*;

public class RotateList {

    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return;  // Edge case: empty list
        k = k % n; // Handle cases where k > n
        if (k == 0) return;

        // Reverse first k elements
        reverse(list, 0, k - 1);
        // Reverse remaining elements
        reverse(list, k, n - 1);
        // Reverse entire list
        reverse(list, 0, n - 1);
    }

    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;
        rotateList(numbers, k);
        System.out.println("Rotated List: " + numbers);
    }
}
