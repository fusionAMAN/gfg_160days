import java.util.ArrayList;
import java.util.Arrays;

public class jobseqproblem {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        int[][]prof=new int[n][2];
        for(int i=0;i<n;i++){
            prof[i][0]=deadline[i];
            prof[i][1]=profit[i];
        }
        Arrays.sort(prof,(a,b)->b[1]-a[1]);
        int maxdead=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxdead=Math.max(maxdead,deadline[i]);
           }

        int sum=0;
        int count=0;
           
        int arr[]=new int[maxdead];
        Arrays.fill(arr,0);
        for(int i=0;i<n;i++){
               int p=prof[i][1];
               int d=prof[i][0];
               for(int j=d-1;j>=0;j--){
                   if(arr[j]==0){
                   arr[j]=p;
                   count++;
                   sum+=arr[j];
                   break;
               }
               
               }
               
           }
        ArrayList<Integer>pq=new ArrayList<>();
        pq.add(count);
        pq.add(sum);
        return pq;
    }
}
