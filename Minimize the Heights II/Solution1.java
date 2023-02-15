// Max Heights I

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int min=arr[0], max=arr[n-1], diff=max-min;
//         System.out.println(Arrays.toString(arr));
        for(int i=1; i<n; i++){;
            // if(arr[i]-k < 0)    arr[i] = arr[i] + 2*k;
            min = Math.min(arr[0]+k, arr[i]-k);
            max = Math.max(arr[i-1]+k, arr[n-1]-k);
            // System.out.println(min+"----------"+max);
            diff = Math.min(diff, max-min);
        }
        return diff;
    }
}
