class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        String e = arr[0];
        int i;
        for(i=1; i<n; i++){
            while(!arr[i].startsWith(e)){
                e = e.substring(0,e.length()-1);
                if(e.length()==0) return "-1";
            } 
        }
        return e;
    }
}
