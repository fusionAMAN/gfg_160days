import java.util.Arrays;
import java.util.PriorityQueue;

public class minimumplatform {
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n=arr.length;
        int time[][]=new int[n][2];
        for(int i=0;i<n;i++){
            time[i][0]=arr[i];
            time[i][1]=dep[i];
        }
        Arrays.sort(time,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        pq.add(time[0][1]);
        for(int i=1;i<n;i++){
            if(pq.peek()<time[i][0]){
                pq.poll();
            }
            pq.add(time[i][1]);
        }
        return pq.size();
    }
}
