class Solution { 
    int minSubset(int[] arr,int N) { 
        Arrays.sort(arr);
        long sum = 0, sub=0;
        int c=0;
        for(int e: arr) sum+=e;
        int i = N-1;
        while(sub<=sum-sub){
            sub+=arr[i];
            i--;
            c++;
        }
        return c;
    }
}
