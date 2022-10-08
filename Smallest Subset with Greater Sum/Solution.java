class Solution { 
    int minSubset(int[] arr,int N) { 
        Arrays.sort(arr);
        int sum = 0, c=0, sub=0;
        for(int e: arr) sum+=e;
        int i = N-1
        while(sub<=sum){
            sub=+arr[i];
            sum-=arr[i];
            c++;
        }
        return c;
    }
}
