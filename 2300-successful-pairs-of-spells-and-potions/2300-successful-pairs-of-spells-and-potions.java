class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        if (spells == null || spells.length == 0 || potions == null || potions.length == 0 || success < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(potions);

        int[] pairs = new int[spells.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = countPotions(spells[i], potions, success);
        }
        return pairs;
    }

    private int countPotions(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long) spell * potions[mid];
            if (product >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return potions.length - left;
    }
}

// time  - O(m log m)
// space - O(n)
