class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dist[]=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        
        for(int i=0;i<V-1;i++){
            for(int[]edg:edges){
                int u=edg[0];
                int v=edg[1];
                int w=edg[2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
       for(int[]edg:edges){
           int u=edg[0];
           int v=edg[1];
           int w=edg[2];
           if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
               return new int[]{-1};
           }
       }
       for(int i=0;i<V-1;i++){
           if(dist[i]==Integer.MAX_VALUE){
               dist[i]=100000000;
           }
       }
       return dist;
    }
}
