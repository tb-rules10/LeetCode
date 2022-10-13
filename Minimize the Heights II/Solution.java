class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int min=arr[0], max=arr[n-1], diff=max-min;
        for(int i=1; i<n; i++){
            min = Math.min(arr[0]+k, arr[i]-k);
            max = Math.max(arr[i-1]+k, arr[n-1]-k);
            // System.out.println(min+"----------"+max);
            if(min < 0) continue;
            diff = Math.min(diff, max-min);
        }
        return diff;
    }
}
