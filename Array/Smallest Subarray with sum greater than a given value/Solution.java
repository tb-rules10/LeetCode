class Solution {
    public int minSubArrayLen(int x, int[] arr) {
        int i=0, j=0, sum=0, min=Integer.MAX_VALUE;
        while(j<arr.length){
            sum += arr[j++];
            while(sum>=x && i<j){
                min = Math.min(min,j-i);
                sum -= arr[i++];
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
