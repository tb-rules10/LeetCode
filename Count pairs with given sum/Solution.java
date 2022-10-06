class Solution {
     int getPairsCount(int[] arr, int n, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int count = 0;
       for(int i =0;i<n;i++){
           //asking if the map contains pair
           if (map.containsKey(k - arr[i])) {
               count += map.get(k-arr[i]);
           }
           //asking if the map contains the digit
           if(map.containsKey(arr[i])){
               map.put(arr[i],map.get(arr[i])+1);
           }
           //if it doesn't contains then adding that digit to map.
           else{
               map.put(arr[i],1);
           }
       }
       return count;
   }
}
