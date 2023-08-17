class Solution {
    public String convert(String s, int nR) {
        if(nR==1) return s;
        int c=0, i=0;
        String str = "";
        char[][] arr = new char[nR][s.length()];
        Queue<Character> q = new LinkedList<>();
        for(char e: s.toCharArray())    q.add(e);
        // System.out.println(Arrays.asList(q));
        while(q.size()!=0){
            for( ;i<nR; i++){
                if(q.size()!=0){
                    // System.out.println(q.peek());
                    // System.out.printf("%d\t%d\n",i,c);
                    arr[i][c] = q.poll();
                }
                else break;
            }
            i--;
            i--;
            c++;
            while(i!=0){
                if(q.size()!=0){
                    // System.out.println(q.peek());
                    // System.out.printf("%d\t%d\n",i,c);
                    arr[i][c] = q.poll();
                }
                else break;
                i--;
                c++;
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        // System.out.println();
        // System.out.println();
        for(i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++)
                // System.out.print(arr[i][j]);
                if(arr[i][j]!='\u0000') str += arr[i][j];
        }
        // System.out.println(str);
        return str;
    }
}
