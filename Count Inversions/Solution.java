// https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

// Just add one statement to Merge sort

class Solution
{
    static long ans;
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        ans = 0;
        mergeSort(arr, 0, N-1);
        return ans;
    }
    static void mergeSort(long arr[], long l, long r)
    {
        if (l < r) {
            long m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    static void merge(long arr[], long l, long m, long r)
    {
        long n1 = m - l + 1;
        long n2 = r - m;
        long L[] = new long[(int)n1];
        long R[] = new long[(int)n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[(int)(l + i)];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[(int)(m + 1 + j)];
        int i = 0, j = 0;
        int k = (int)l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                ///////////////////////////
                ans += n1 - i;
                ///////////////////////////
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
