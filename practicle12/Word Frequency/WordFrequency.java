// Demonstrates word frequency counting and sorting
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
 
public class WordFrequency {
 
    public static void main(String[] args) {
 
        // Sample paragraph
        String paragraph = "java is easy java is powerful java";
 
        // Split paragraph into individual words
        String[] words = paragraph.split("\\s+");
 
        // HashMap to store words and their frequencies
        HashMap<String, Integer> frequencyMap = new HashMap<>();
 
        // Count the frequency of each word
        for (String word : words) {
            frequencyMap.put(word,
                    frequencyMap.getOrDefault(word, 0) + 1);
        }
 
        // Convert HashMap entries into a list for sorting
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());
 
        // Sort words by frequency in descending order
        entries.sort(
                Comparator.comparing(
                        Map.Entry<String, Integer>::getValue
                ).reversed()
        );
 
        // Display the word frequencies
        System.out.println("Word Frequency:");
 
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue());
        }
    }
}
