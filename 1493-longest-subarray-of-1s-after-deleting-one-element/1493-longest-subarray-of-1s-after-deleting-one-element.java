class Solution {
    private static final int MAX_ZEROES = 1;
    
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxCount = 0;
        int zeroCount = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > MAX_ZEROES) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, right - left);
            right++;
        }
        
        return maxCount;
    }
}

// time  - O(n)
// space - O(1)
