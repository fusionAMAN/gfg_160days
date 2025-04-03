//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int n=mat.length;
        int m=mat[0].length;
        Queue<int[]>que=new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){
                    que.add(new int[]{i,j});
                }
                if(mat[i][j]!=0){
                    count++;
                }
            }
        }
        if(count==0)return 0;
        int countmin=0;
        int c=0;
        int dx[]=new int[]{0,0,1,-1};
        int dy[]=new int[]{1,-1,0,0};
        while(!que.isEmpty()){
            int size=que.size();
            c+=size;
            for(int i=0;i<size;i++){
                int []point=que.poll();
                for(int j=0;j<4;j++){
                    int x=point[0]+dx[j];
                    int y=point[1]+dy[j];
                    if(x<0||y<0||x>=n||y>=m||mat[x][y]==0||mat[x][y]==2)continue;
                    mat[x][y]=2;
                    que.add(new int[]{x,y});
                }
            }
            if(que.size()!=0){
                countmin++;
            }
            
        }
        return count==c?countmin:-1;
    }

}

