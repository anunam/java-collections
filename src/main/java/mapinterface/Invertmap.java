package mapinterface;

import java.util.*;

public class Invertmap {
    public static void main(String[] args) {
        HashMap<Character, Integer> s = new HashMap<>();
        s.put('A', 1);
        s.put('B', 1);
        s.put('C', 2);

        HashMap<Integer, ArrayList<Character>> mp = new HashMap<>();

        for (Map.Entry<Character, Integer> e : s.entrySet()) {  // ✅ Explicit type instead of `var`
            int key = e.getValue();
            char value = e.getKey();

            // If key does not exist, initialize with a new ArrayList
            mp.putIfAbsent(key, new ArrayList<>());

            // Add the character to the corresponding list
            mp.get(key).add(value);
        }

        System.out.println(mp);
    }
}
