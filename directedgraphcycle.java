//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        int[]indegree=new int[V];
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer>que=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        int count=0;
        while(!que.isEmpty()){
            int u=que.poll();
            count++;
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0)que.add(v);
            }
        
        }
        
        return count!=V;
        /*count keeps track of how many nodes you've processed during the topological sort.

If the graph has no cycles, you should be able to process all V nodes.

If there's a cycle, some nodes will never reach in-degree = 0, so they won’t be processed. */
    }
}