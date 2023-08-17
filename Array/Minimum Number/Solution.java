class Solution {
    public static int minimumNumber(int n, int[] arr) {
         int l = 0, r = n-1;
        while(l<r){
            if(arr[l]>=arr[r]) arr[l] = arr[l]%arr[r];
            else arr[r] = arr[r]%arr[l];
            if (arr[l]==0) l++;
            else if (arr[r]==0) r--;
        }
        return arr[l];
    }
}
