class Solution {
    public static int noConseBits(int n) {
        // code here
        int c=0;
        String a=Integer.toBinaryString(n);
        char ar[]=a.toCharArray();
        for(int i=0;i<ar.length-2;i++)
            if(ar[i]=='1'&&ar[i+1]=='1'&&ar[i+2]=='1')
                ar[i+2]='0';
        String b=String.valueOf(ar);
        return Integer.parseInt(b,2);
    }
}
