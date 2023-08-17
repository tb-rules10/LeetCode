class Solution{
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
        }swap(arr, i++, high); 
        return (i);
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        int pi = partition(arr,l,r);
        if (pi==k-1) 
            return arr[pi];
        else if(pi<k-1)
            return kthSmallest(arr,l,pi-1,k);
        else 
            return kthSmallest(arr,pi+1,r,k);
    }
}
