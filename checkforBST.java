

// User function Template for Java

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public Boolean check(Node root, int min,int max){
        if(root==null)return true;
        if(root.data<min || root.data>max){
            return false;
        }
        return check(root.left,min,root.data) && check(root.right,root.data,max);
    }
}