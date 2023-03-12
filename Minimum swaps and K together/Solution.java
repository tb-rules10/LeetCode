// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

class Complete{
    int minSwap(int arr[], int n, int k) {
        int count=0;
        for(int e: arr) 
            if(e<=k) count++;
        if(count == 0)    return 0;
        int i=0, j=0, bad=0, minSwaps=Integer.MAX_VALUE;
        while(j<n){
            if(j-i+1 == count){
                if(arr[j]>k)    bad++;
                minSwaps = Math.min(minSwaps,bad);
                if(arr[i]>k)    bad--;
                i++;j++;
            }
            else{
                if(arr[j]>k)    bad++;
                j++;
            }
        }
        return minSwaps;
    }
}
