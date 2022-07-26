class Solution {
    public void sortColors(int[] nums) {
        int a=0,b=0,c=0,ind=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) a++;
            else if(nums[i] == 1) b++;
            else c++;
        }
        // System.out.println(a+"\t"+b+"\t"+c);
        while(a!=0) {
            nums[ind++] = 0; a--;}
        while(b!=0) {
            nums[ind++] = 1; b--;}
        while(c!=0) {
            nums[ind++] = 2; c--;}        
    }
}
