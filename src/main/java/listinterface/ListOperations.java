package listinterface;
import java.util.*;

public class ListOperations {

    // Find frequency of elements
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new TreeMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("Frequency: " + findFrequency(words));
    }
}
