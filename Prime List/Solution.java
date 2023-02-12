class Solution
{
    boolean isPrime(int x){
        if(x<=1)    return false;
        boolean bool =  true;
        for(int i = 2; i<=Math.sqrt(x); i++)
            if(x%i == 0)    bool = false;
        return bool;
    }
    
    Node primeList(Node head){
        //code here
        Node curr = head;
        while(curr != null){
            int data = curr.val;
            int p = 0, i = 1;
            if(isPrime(data))
                p = data;
            while(p==0){
                if(isPrime(data - i))
                    p = data-i;
                else if(isPrime(data + i))
                    p = data+i;
                i++;
            }
            curr.val = p;
            curr = curr.next;
        }
        return head;
    }
}
