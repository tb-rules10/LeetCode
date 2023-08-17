class Solution
{
    
    // static class Pair implements Comparable<Pair>{
    static class Pair{
        int distance;
        int node;
        Pair(int dist, int node){
            this.distance = dist;
            this.node =  node;
        }
        // @Override public int compareTo(Pair x){
        //     return this.distance - x.distance;
        // }
    }
    
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // System.out.println(Arrays.toString(adj.toArray()));
        // PriorityQueue<Pair> pq = new PriorityQueue<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
            
        int[] dist = new int[v];
        for(int i=0; i<v; i++) dist[i] = (int)1e9;
        
        dist[S] = 0;
        pq.add(new Pair(0,S));
        
        while(pq.size()!=0){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            for(int i=0; i<adj.get(node).size(); i++){
                int edgeWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(dis + edgeWt < dist[adjNode]){
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

