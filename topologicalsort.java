/*
What is Topological Sort?
Topological Sort is a linear ordering of nodes in a Directed Acyclic Graph (DAG) 
such that for every edge u → v, node u appears before v in the ordering.


Two Ways to Perform Topo Sort:
Kahn’s Algorithm (BFS-Based)
💡 Think level-wise processing — tasks with no prerequisites go first.

🔁 Steps:
Build Adjacency List from given edges.

Calculate in-degree of all nodes.

in-degree[v]++ for each edge u → v

Push all nodes with in-degree = 0 to a queue.

While queue is not empty:

Remove a node u from queue, add it to result.

For each neighbor v of u, reduce in-degree[v]--.

If in-degree[v] == 0, push v into the queue.

If all nodes are processed → return result.

Else: Cycle detected (not a DAG).

✅ Time: O(V + E)
✅ Space: O(V + E)
🔷 2. DFS-Based Topo Sort
💡 Think reverse finishing order — post-order traversal

🔁 Steps:
Build Adjacency List from edges.

Create visited[] and a stack.

For every unvisited node:

Call recursive DFS:

Mark node as visited.

Visit all neighbors.

After visiting neighbors, push node into stack.

After all calls, pop elements from stack → gives topological order.

✅ Time: O(V + E)
✅ Space: O(V + E)


Example Graph:
Copy code
5 → 0  
5 → 2  
4 → 0  
4 → 1  
2 → 3  
3 → 1
✅ One possible Topo Sort: [4, 5, 0, 2, 3, 1]

 */

 /* note indegree array:
  * 
 Outer Loop: for (int u = 0; u < V; u++)
Go through each node u.

Inner Loop: for (int v : adj.get(u))
Go through every neighbor v that u points to (i.e., u → v).

Since v has an edge coming into it, we increment indegree[v].

🔢 Example Calculation:
Go node-by-node:

2 → 3 → indegree[3]++

3 → 1 → indegree[1]++

4 → 0 → indegree[0]++

4 → 1 → indegree[1]++

5 → 0 → indegree[0]++

5 → 2 → indegree[2]++
  */

  //{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        //step 1 creating adjancey matrix
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edges[]:edges){
            int u=edges[0];
            int v=edges[1];
            adj.get(u).add(v);
        }

        // step 2 creating indegree martix
        int[]indegree=new int[V];
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        // step 3: add all node in queue which have indegree 0
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        // step 4 performing bfs traversal
        ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            ans.add(u);
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return ans;
    }
}