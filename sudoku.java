//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        solve(mat);
        }
    private static boolean solve(int [][]mat){
            for(int r=0;r<9;r++){
                for(int c=0;c<9;c++){
                    if(mat[r][c]==0){
                        for(int num=1;num<=9;num++){
                            if(isvalid(mat,r,c,num)){
                                mat[r][c]=num;
                                if(solve(mat)){
                                    return true;
                                }
                                mat[r][c]=0;// backtrack
                            }
                        }
                        return false;// no valid number is found
                    }
                }
            
            }
            return true;
        }
        // code here
    // check number is safe or not
    private static boolean isvalid(int [][]mat,int row,int col,int num){
        // check row
        for(int i=0;i<9;i++){
            if(mat[row][i]==num)return false;
        }
        // check col
        for(int i=0;i<9;i++){
            if(mat[i][col]==num)return false;
        }
        
        // check 3X3 subgrid
        int startrow=row-row%3;
        int startcol=col-col%3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(mat[i][j]==num)return false;
            }
        }
        return true;
    }

}