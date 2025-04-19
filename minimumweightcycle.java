import java.util.Arrays;

/**
 * 
 Step-by-Step Explanation
Step 1: Initialize
Create two 2D arrays:

dist[i][j]: holds the shortest distance from node i to j.

graph[i][j]: holds the original direct edge weight from i to j.

Fill both with a large number (INF) except for dist[i][i] = 0.

Step 2: Fill Direct Edges
For each edge (u, v, wt) in the input:

Set graph[u][v] = wt and graph[v][u] = wt

Also update dist[u][v] = wt and dist[v][u] = wt
(because it's an undirected graph)

Step 3: Floyd-Warshall + Triangle Cycle Check
For each intermediate node k:

(a) Check for cycles:

For every pair of nodes (i, j) where i ≠ j, i ≠ k, j ≠ k:

If dist[i][j], graph[j][k], and graph[k][i] are all valid (not INF),

Then a cycle exists: i → j → k → i

Total cycle length = dist[i][j] + graph[j][k] + graph[k][i]

Update minCycle = min(minCycle, this length)

(b) Update shortest paths:

Run Floyd-Warshall:

dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]) 
 
 */

 //{ Driver Code Starts
import java.util.*;

public class minimumweightcycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    public int findMinCycle(int V, int[][] edges) {
        int INF = Integer.MAX_VALUE / 2; // to avoid overflow
        int[][] dist = new int[V][V];
        int[][] graph = new int[V][V];

        // Initialize distance and graph matrices
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(graph[i], INF);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u][v] = wt;
            graph[v][u] = wt;
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        int minCycle = INF;

        // Floyd-Warshall with triangle checking
        for (int k = 0; k < V; k++) {
            // Check for cycles through node k BEFORE updating dist
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i != j && j != k && i != k &&
                        dist[i][j] != INF && graph[j][k] != INF && graph[k][i] != INF) {

                        int cycleLen = dist[i][j] + graph[j][k] + graph[k][i];
                        minCycle = Math.min(minCycle, cycleLen);
                    }
                }
            }

            // Floyd-Warshall update
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return minCycle == INF ? -1 : minCycle;
    }
}
