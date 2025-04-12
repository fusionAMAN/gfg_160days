//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int max=0;
    int diameter(Node root) {
        // Your code here
        height(root);
        return max;
    }
    int height(Node root){
        if(root==null)return 0;
        
        int left=height(root.left);
        int right=height(root.right);
        
         max=Math.max(max, left+right);
        return 1+Math.max(left,right);
    }
}

/*      1
       / \
      2   3
     / \     
    4   5 
     Step-by-Step Traversal (Post-order):
We use post-order traversal: Left → Right → Root

🔹 Step 1: Visit Node 4
Node 4 has no children, so:

left = 0, right = 0

diameter_through_4 = 0 + 0 = 0

Update max = 0

Return height = 1 + max(0, 0) = 1

🔹 Step 2: Visit Node 5
Node 5 has no children, so:

left = 0, right = 0

diameter_through_5 = 0 + 0 = 0

max = max(0, 0) = 0

Return height = 1

🔹 Step 3: Visit Node 2
Left height (from Node 4) = 1

Right height (from Node 5) = 1

diameter_through_2 = 1 + 1 = 2

Update max = max(0, 2) = 2

Return height = 1 + max(1, 1) = 2

🔹 Step 4: Visit Node 3
Node 3 has no children:

left = 0, right = 0

diameter_through_3 = 0 + 0 = 0

max = 2 (unchanged)

Return height = 1

🔹 Step 5: Visit Node 1 (Root)
Left height (from Node 2) = 2

Right height (from Node 3) = 1

diameter_through_1 = 2 + 1 = 3

Update max = max(2, 3) = 3

Return height = 1 + max(2, 1) = 3

✅ Final Result:
Diameter of the tree = 3 (edges)

Path: 4 → 2 → 1 → 3


    
    
    
    
    */

    /* */