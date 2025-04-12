//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
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

class GFG {

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

            Solution ob = new Solution();
            System.out.println(ob.height(root));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
       if(node==null)return -1;
       int left=height(node.left);
       int right=height(node.right);
       return 1+Math.max(left,right);
    }
}
/*
 * 
         1
       / \
      2   3
     / \
    4   5
    Call Stack Visualization:
scss
Copy code
height(1)
├── height(2)
│   ├── height(4) → 1
│   └── height(5) → 1
│   → returns 2
└── height(3) → 1
→ returns 3

height(1)
Not null → call height(2) and height(3)

⬇️ height(2)
Not null → call height(4) and height(5)

⬇️ height(4)
Node 4 has no children → call height(null) → returns 0 for both left and right

So, height(4) = 1 + max(0, 0) = 1

⬇️ height(5)
Node 5 has no children → call height(null) → returns 0 for both left and right

So, height(5) = 1 + max(0, 0) = 1

⬅️ Back to height(2)
Now leftHeight = 1 (from 4), rightHeight = 1 (from 5)
→ height(2) = 1 + max(1, 1) = 2

⬇️ height(3)
Node 3 has no children → call height(null) → returns 0 for both

So, height(3) = 1 + max(0, 0) = 1

⬅️ Back to height(1)
Now leftHeight = 2 (from 2), rightHeight = 1 (from 3)
→ height(1) = 1 + max(2, 1) = 3




 */