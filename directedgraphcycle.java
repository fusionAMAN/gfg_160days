class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edge list to adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        // Check for cycles in all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recursionStack)) {
                    return true; // cycle found
                }
            }
        }

        return false; // no cycle found
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recursionStack) {
        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true; // back edge found
            }
        }

        recursionStack[node] = false;
        return false;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // For undirected graph, add both directions
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) return true;
            } else if (neighbor != parent) {
                return true; // Cycle found
            }
        }
        return false;
    }
}
