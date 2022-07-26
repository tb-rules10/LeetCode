class Solution {
    public void reverseString(char[] s) {
        // int n = s.length;
        char t;
        for (int i =0; i<s.length/2; i++){
            t = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = t;
        }
    }
}
