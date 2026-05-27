class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] frequencyArray1 = buildFrequencyArray(word1);
        int[] frequencyArray2 = buildFrequencyArray(word2);

        boolean isSameCharacters = isSameCharacters(frequencyArray1, frequencyArray2);
        if (!isSameCharacters) {
            return false;
        }
        
        return isSameFrequencies(frequencyArray1, frequencyArray2);
    }

    private int[] buildFrequencyArray(String word) {
        int[] frequencyArray = new int[26];
        for (char c : word.toCharArray()) {
            frequencyArray[c - 'a']++;
        }
        return frequencyArray;
    }

    private boolean isSameCharacters(int[] frequencyArray1, int[] frequencyArray2) {
        for (int i = 0; i < frequencyArray1.length; i++) {
            if ((frequencyArray1[i] == 0 && frequencyArray2[i] != 0) || (frequencyArray1[i] != 0 && frequencyArray2[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameFrequencies(int[] frequencyArray1, int[] frequencyArray2) {
        Arrays.sort(frequencyArray1);
        Arrays.sort(frequencyArray2);
        for (int i = 0; i < frequencyArray1.length; i++) {
            if (frequencyArray1[i] != frequencyArray2[i]) {
                return false;
            }
        }
        return true;
    }
}

// time  - O(n * log n)
// space - O(1)
