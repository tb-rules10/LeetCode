class Solution {
    public int maxProduct(int[] nums) {
        int product=1,ans=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
        if(product==0) product=1;
        product*=nums[i];
        ans=Math.max(ans,product);
    }
    product=1;
    for(int i=nums.length-1;i>=0;i--){
        if(product==0) product=1;
        product*=nums[i];
        ans=Math.max(ans,product);
    }
    return ans;
    }
}
