class Solution{
    boolean isBST(Node root){
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean check(Node root, int min, int max){
        if(root==null)return true;
        if(root.data<min || root.data>max){
            return false;
        }
        return check(root.left,min,root.data)&& check(root.right,root.data,max);
    }
}