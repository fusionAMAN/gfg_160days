public class GasStation
 {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        int tank=0;
        int curr=0;
        int index=0;
        for(int i=0;i<gas.length;i++){
           int gain=gas[i]-cost[i];
           tank+=gain;
           curr+=gain;
           if(curr<0){
               index=i+1;
               curr=0;
           }
            
        }
        return tank>=0?index:-1;
        
    }
}
