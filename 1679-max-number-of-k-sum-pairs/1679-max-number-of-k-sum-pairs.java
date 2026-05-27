class Solution {
    public int maxOperations(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(nums);

        int operationsCount = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                operationsCount++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        
        return operationsCount;
    }
}

// time  - O(n)
// space - O(1)
