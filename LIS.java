public class LIS {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int dp[]=new int[n];// dp[i]stores the length of the LIS ending at index i
        for(int i=0;i<n;i++){
            dp[i]=1; // each element is a subsequence of length 1 by itself
        }
        
        // iterate through each element in the array
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int maxlen=0;
        for(int i=0;i<n;i++){
            maxlen=Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
}
