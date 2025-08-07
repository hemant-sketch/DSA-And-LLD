import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        // Create a frequency map for the given words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate through the string 's' with different starting offsets
        // This handles cases where the concatenated substring might not start at index 0
        // but at index 1, 2, ..., (wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> currentWindowCount = new HashMap<>();

            // Slide the window
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String currentWord = s.substring(j, j + wordLen);

                // If the current word is in our target word list
                if (wordCount.containsKey(currentWord)) {
                    currentWindowCount.put(currentWord, currentWindowCount.getOrDefault(currentWord, 0) + 1);
                    count++;

                    // If we have more of a word than needed, shrink the window from the left
                    while (currentWindowCount.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindowCount.put(leftWord, currentWindowCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If we have found all words in the current window
                    if (count == numWords) {
                        result.add(left);
                        // Move the window to find the next possible substring
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindowCount.put(leftWord, currentWindowCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    // If the current word is not in our target words, reset the window
                    currentWindowCount.clear();
                    count = 0;
                    left = j + wordLen; // Start a new window from after this invalid word
                }
            }
        }
        return result;
    }
}
