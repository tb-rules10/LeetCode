// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] exists = new boolean[n];
        for (int num : nums) {
            if (num > 0 && num <= n) exists[num - 1] = true;
        }
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) return i + 1;
        }
        return n + 1;
    }
}
