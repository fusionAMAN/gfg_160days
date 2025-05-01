import java.util.HashMap;

public class Partitionstring {
    public int maxPartitions(String s) {
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),i);
        }
        int end=0;
        int partition=0;
        for(int i=0;i<n;i++){
            end=Math.max(end,map.get(s.charAt(i)));
            if(i==end){
                partition++;
            }
        }
        return partition;
}
}
