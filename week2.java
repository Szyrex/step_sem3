import java.util.*;
public class week2 {
    //WordFrequencyReport


    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Convert to lowercase
        String cleaned = feedback.toLowerCase();

        // Remove punctuation
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");

        // Split into words
        String[] words = cleaned.split("\\s+");

        // Store word frequencies
        HashMap<String, Integer> frequency =
            new HashMap<>();

        for (String word : words) {

            // Check whether word is a stop word
            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (isStopWord) {
                continue;
            }

            if (frequency.containsKey(word)) {

                frequency.put(
                    word,
                    frequency.get(word) + 1
                );

            } else {

                frequency.put(word, 1);
            }
        }

        // Convert HashMap to list
        ArrayList<Map.Entry<String, Integer>> entries =
            new ArrayList<>(frequency.entrySet());

        // Sort by count descending
        entries.sort(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}

    
