public class LCS {
    public static int longestcommonsubsequence(String s1, String s2){
        int n1=s1.length();
        int n2=s2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }
}
