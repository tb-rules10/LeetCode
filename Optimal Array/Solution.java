// https://practice.geeksforgeeks.org/problems/d4aeef538e6dd3280dda5f8ed7964727fdc7075f/1


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        long res[] = new long[n];
        for(int i=1;i<n;i++){
            res[i]=a[i]-a[i/2]+res[i-1];
        }
        return res;
    }
}
