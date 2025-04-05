//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean visit[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L'&&! visit[i][j]){
                    dfs(grid,visit,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid, boolean[][]visit,int x, int y, int n, int m){
        visit[x][y]=true;
        for(int i=0;i<8;i++){
            int newx=x+dx[i];
            int newy=y+dy[i];
            if(isvalid(grid,newx,newy,n,m) && grid[newx][newy]=='L' && !visit[newx][newy]){
                dfs(grid,visit,newx,newy,n,m);
            }
        }
    }
    public boolean isvalid(char[][]grid,int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
}