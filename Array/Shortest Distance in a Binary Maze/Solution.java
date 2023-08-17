class Solution {

    class Pair{
        int x;
        int y;
        Pair(int i,int j){
            x=i;
            y=j;
        }
    }
    
    int shortestPath(int[][] grid, int[] src, int[] des) {
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src[0],src[1]));
        grid[src[0]][src[1]]=0;
        int dis=0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                Pair curr=q.remove();
                int i=curr.x;
                int j=curr.y;
                if(i==des[0] && j==des[1]) return dis;
                for(int k=0; k<4; k++){
                    int newr = i + dr[k];
                    int newc = j + dc[k];
                    if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && grid[newr][newc]==1){
                        grid[newr][newc] = 0;
                        q.add(new Pair(newr,newc));
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}
