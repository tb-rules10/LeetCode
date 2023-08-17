
class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        int prefix_sum = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            prefix_sum += arr[i];
            if(prefix_sum==0 || s.contains(prefix_sum))
                return true;
            s.add(prefix_sum);
            // System.out.println(Arrays.toString(s.toArray()));
        }
        return false;
    }
}
