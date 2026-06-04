class Solution {
    public List<Integer> partitionLabels(String str) {
        ArrayList<Integer> partitions = new ArrayList<>();

        for (int idx = 0; idx < str.length();) {

            int startIndex = idx;
            int endIndex = str.lastIndexOf(str.charAt(startIndex));

            for (int s = startIndex + 1; s <= endIndex - 1; s++) {

                int lastIndexOfNextChar = str.lastIndexOf(str.charAt(s));

                if (lastIndexOfNextChar > endIndex) {
                    endIndex = lastIndexOfNextChar;
                }
            }

            partitions.add(endIndex - startIndex + 1);
            idx = endIndex + 1;
        }

        return partitions;
    }
}
