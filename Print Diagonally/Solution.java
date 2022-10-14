class Solution{
    static ArrayList<Integer> downwardDigonal(int n, int a[][])
    {
        // code here 
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=0; i<n; i++)
            for(int j=i; j>=0; j--)
                list.add(a[j][i-j]);
        for(int i=1; i<n; i++)
            for(int j=n-i-1; j>=0; j--)
                list.add(a[i+j][n-j-1]);
        return list;
    }
}
