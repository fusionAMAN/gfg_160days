//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

// User function Template for Java
class Trie {
    class Node{
        Node[]children;
        boolean eow;
        public Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }
    private Node root;

    public Trie() {
        // Implement Trie
        root= new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node current=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(current.children[idx]==null){
                current.children[idx]= new Node();
            }
            current=current.children[idx];
           
        }
        current.eow=true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
            Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {
                return false;  
            }
            current = current.children[idx];
        }
        return current.eow;  
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Node current=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(current.children[idx]==null){
                return false;
            }
            current=current.children[idx];
        }
        return true;
    }
}


//{ Driver Code Starts.

public class implementation_Trie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int q = sc.nextInt();
            sc.nextLine();
            List<Boolean> ans = new ArrayList<>();
            Trie ob = new Trie();

            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                if (i != q - 1) sc.nextLine();

                if (x == 1) {
                    ob.insert(s);
                } else if (x == 2) {
                    ans.add(ob.search(s));
                } else if (x == 3) {
                    ans.add(ob.isPrefix(s));
                }
            }

            for (Boolean result : ans) {
                System.out.print(result + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends