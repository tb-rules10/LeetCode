class Solution {
    static int countOfSubstrings(String S, int K) {
        // code here
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        String sub, s;
        int c=0, N=S.length();
        char ch;
        int i=0,j=0;
        while(j<N){
            ch = S.charAt(j);
            if(j-i+1==K){
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }
                else{
                    map.put(ch,1);
                }
                // System.out.println(map.keySet().toString());
                // System.out.println(map.values().toString());
                if(map.size()==K-1) c++;
                // System.out.println("[---"+map.get(S.charAt(i))+"---]");
                if(map.get(S.charAt(i))>1)
                    map.put(S.charAt(i),map.get(S.charAt(i))-1);
                else
                    map.remove(S.charAt(i));
                i++;
                j++;
            }
            else{
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }
                else{
                    map.put(ch,1);
                }
                j++;
            }
        }
        return c;
    }
}
