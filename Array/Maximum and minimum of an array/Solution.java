public class Solution{
    int min,max;
    static Solution getminmax(int[] arr){
        Solution mm = new Solution();
        int n = arr.length;
        if(n==0) {
            System.out.println("Empty Array");
            System.exit(0);
        }
        if(n==1){
            mm.min = arr[0];
            mm.max = arr[0];
            return mm;
        }
        mm.min = Math.min(arr[0], arr[1]);
        mm.max = Math.max(arr[0], arr[1]);
        if(n==2){
            return mm;
        }
        for (int i=2; i<n; i++){
            if(mm.min>arr[i])
                mm.min = arr[i];
            if(mm.max<arr[i])
                mm.max = arr[i];
        }
        return mm;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Solution ob = getminmax(arr);
        System.out.println("Max = "+ob.max);
        System.out.println("Min = "+ob.min);

    }
}
