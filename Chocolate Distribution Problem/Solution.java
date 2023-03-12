class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int i=0, j=0, min=Integer.MAX_VALUE;
        while(j<n){
            if(j-i+1 == m){
                min = Math.min(min, a.get(j)-a.get(i));
                j++;
                i++;
            }
            else j++;
        }
        // System.out.println(min);
        return (long)min;
    }
}
