public class Solution {
    static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            if (arr[low] <= 0)
                low++;
            else
                swap(arr, low, high--);
        }
        for (int e : arr)
            System.out.print(e + " , ");
    }
}
