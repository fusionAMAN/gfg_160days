

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected: add both directions
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle
    }

    private boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Found a back-edge that isn't to the parent
            }
        }
        return false;
    }
}

/* 
 * class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected: add both directions
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // {current_node, parent}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // Visited but not parent => cycle
                    return true;
                }
            }
        }

        return false;
    }
}

*/