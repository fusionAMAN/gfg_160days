public class roottoleaf {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        ArrayList<Integer>currpath=new ArrayList<>();
        helper(root,currpath,res);
        return res;
        // code here
        
    }
    public static void helper(Node root, ArrayList<Integer>currpath,ArrayList<ArrayList<Integer>>arr){
      if(root==null)return;
      currpath.add(root.data);
      
      if(root.left==null && root.right==null){
          arr.add(new ArrayList<>(currpath));
      }
      else{
          helper(root.left,currpath,arr);
          helper(root.right,currpath,arr);
      }
      //backtrack
      currpath.remove(currpath.size()-1);
      /*Why We Do Backtracking (currentPath.remove(currentPath.size() - 1)):
When solving recursive problems like root-to-leaf paths, backtracking is necessary to clean up the current path before returning to a previous recursive state. Here's why:

Let’s break it down:
Suppose the tree is:

markdown
Copy code
    1
   / \
  2   3
Now, imagine how the currentPath evolves:

Start at root 1:
currentPath = [1]

Go to left child 2:
currentPath = [1, 2]
Node 2 is a leaf, so we store [1, 2] in result.

Now, we go to the right child 3.
If we didn't remove 2 from the list, the currentPath would still be [1, 2], and adding 3 would give:
[1, 2, 3] → which is wrong.

*/
}
}

