// https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here  
        int low=1, high=2000, num=R*C;
        while(low<=high){
            int mid = (low+high)/2;
            // int count = countSmaller(matrix, mid);
            int count = 0;
            for(int[] arr: matrix) count+=countSmaller(arr,mid);
            if(count<=num/2)
                low = mid+1;
            else 
                high = mid-1;
        }
        return low;
    }
    int countSmaller(int[] arr, int pivot){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] <= pivot)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }
}
