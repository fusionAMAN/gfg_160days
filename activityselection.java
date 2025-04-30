import java.util.Arrays;

public class activityselection {
     public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n=start.length;
        int time[][]=new int[n][2];
        for(int i=0;i<n;i++){
            time[i][0]=start[i];
            time[i][1]=finish[i];
        }
        Arrays.sort(time,(a,b)->Integer.compare(a[1],b[1]));
        int count=1;
        int lastime=time[0][1];
        for(int i=1;i<n;i++){
            if(lastime<time[i][0]){
                count++;
                lastime=time[i][1];
            }
        }
        return count;
    }
}