class Solution{   
public:
    int addMinChar(string str){    
        //code here
        int n=str.size();
        int i=0,j=n-1,ans=n-1;
        
        while(i<j)
        {
            if(str[i]==str[j])
            {
                i++;
                j--;
            }
            else {
                i=0;
                ans--;
                j=ans;
            }
        }
        
        return n-ans-1;
    }
};
