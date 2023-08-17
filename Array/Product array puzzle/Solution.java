class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long[] P = new long[n];
        long f=1;
        for(int i=0; i<n; i++){
            f*= nums[i];
            P[i] = f;
        }
        f=1;
        for(int i=n-1; i>0; i--){
            P[i] = P[i-1] * f;
            f*= nums[i];
        }
        P[0]=f;
        return P;
	}
} 
