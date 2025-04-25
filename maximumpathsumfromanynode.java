public class maximumpathsumfromanynode {
    int findMaxSum(Node node){
        int maxi[]=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        maxsum(node,max);
        return maxi[0];
    }
    public int maxsum(Node node, int maxi[]){
        if(node==null)return 0;
        int left=Math.max(maxsum(node.left,maxi),0);
        int right=Math.max(maxsum(node.right,maxi),0);
        maxi[0]=Math.max(maxi[0],left+right+node.data);
        return node.data+Math.max(left+right);
    }
    
}
