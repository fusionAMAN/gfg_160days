class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>res=new ArrayList<>();
        boolean vis[]=new boolean[adj.size()];
        helper(0,adj,vis,res);
        return res;
    }
    public void helper(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer>res){
        // ArrayList<Integer>res=new ArrayList<>();
        vis[node]=true;
        res.add(node);
        for(int n:adj.get(node)){
            if(!vis[n]){
                helper(n,adj,vis,res);
            }
        }
        // return res;
    }
    
}