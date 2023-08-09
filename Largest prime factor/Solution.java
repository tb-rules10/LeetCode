// https://practice.geeksforgeeks.org/problems/largest-prime-factor2601/1

class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        int ans = 1;
        for(int i=2; i*i<=N; i++)
            while(N%i == 0){
                N = N/i;
                ans = i;
            }        
        if(N != 1) ans = N;
        return ans;
    }
}
