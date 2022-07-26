class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        qsort(arr, 0, arr.length-1);
        return arr[k-1];
    }
    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i,j);
            }
        }swap(arr, i+1, high); 
        return (i+1);
    }
    static void qsort(int[] arr, int low, int high){
        if (low >= high)
            return;
        int pi = partition(arr,low,high);
        qsort(arr,low,pi-1);
        qsort(arr,pi+1,high);
    }
}
