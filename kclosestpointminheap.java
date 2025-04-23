//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int []n:points){
            int x=n[0];
            int y=n[1];
            int ans=distance(x,y);
            pq.add(new int[]{x,y,ans});
        }
        int[][]ans=new int[k][2];
        for(int i=0;i<k;i++){
            int curr[]=pq.poll();
            ans[i][0]=curr[0];
            ans[i][1]=curr[1];
        }
        return ans;
        
    }
    public int distance(int x, int y){
        int xd=(0-x)*(0-x);
        int yd=(0-y)*(0-y);
        int ans=xd+yd;
        return ans;
    }
}



//{ Driver Code Starts.

public class kclosestpointminheap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends