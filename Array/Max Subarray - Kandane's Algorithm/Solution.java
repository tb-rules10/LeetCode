class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0, msum = Integer.MIN_VALUE;
        for(int e: nums){
            sum = Math.max(sum+e, e);
            msum = Math.max(msum,sum);
        }
        return msum;
    }
}
