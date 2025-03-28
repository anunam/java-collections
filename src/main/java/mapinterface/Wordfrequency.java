package mapinterface;
import java.io.*;
import java.util.*;

public class Wordfrequency {
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            // Convert to lowercase and remove punctuation
            line = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
            String[] words = line.split("\\s+"); // Split by spaces

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return wordCount;
    }

    public static void main(String[] args) {
        String filePath = "D:/bridgelabz-workspace/java-collection/src/main/java/mapinterface/word.txt";
        try {
            Map<String, Integer> wordFrequency = countWordFrequency(filePath);
            System.out.println("Word Frequencies: " + wordFrequency);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
