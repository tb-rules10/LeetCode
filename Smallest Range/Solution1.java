// Smallest Range I

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int mx = A[0], mn = A[0];
        for (int a : A) {
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }
//         System.out.printf("%d %d \n",mx,mn);
        return Math.max(0, mx - mn - 2 * K);
    }
}
