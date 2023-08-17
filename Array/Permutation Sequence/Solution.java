// https://leetcode.com/problems/permutation-sequence/description/

class Solution {
    public String getPermutation(int n, int k) {
        int[] A = new int[n];
        for(int i=0; i<n; i++)
            A[i] = i+1;
        for(int i=1; i<k; i++)
            nextPermutation(A);
        String s = "";
        for(int i: A)   s+=i;
        return s;
    }
    public void nextPermutation(int[] A) {
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; 
        if(i >= 0) {                           
            int j = A.length - 1;              
            while(A[j] <= A[i]) j--;      
            swap(A, i, j);                     
        }
        reverse(A, i + 1, A.length - 1);      
}
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
