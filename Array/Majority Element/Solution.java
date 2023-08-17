class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(size == 1)   return a[0];
        for(int e: a){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
                if(map.get(e)>size/2)   return e;
            }
            else
                map.put(e,1);
        }
        return -1;
    }
}
