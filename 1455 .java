class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into an array of words based on whitespace
        String[] words = sentence.split(" ");

        // Iterate through the array
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with the searchWord
            if (words[i].startsWith(searchWord)) {
                // Return 1-based index
                return i + 1;
            }
        }

        // Return -1 if no match is found
        return -1;
    }
}
