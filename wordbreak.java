import java.util.LinkedList;
import java.util.Queue;

public class wordbreak {
    class Node{
        Node []children=new Node[26];
        boolean eow;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }
    public Node root=new Node();
    public void insert(String word){
        int len=word.length();
        int idx;
        Node curr=root;
        for(int i=0;i<len;i++){
            idx= word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word:wordDict){
            insert(word);
        }
        int n=s.length();
        boolean[]visit=new boolean[n+1];
        Queue<Integer>que=new LinkedList<>();
        que.add(0);
        while(!que.isEmpty()){
            int st=que.poll();
            Node curr=new Node();
            for(int i=st;i<n;i++){
                int idx=s.charAt(i)-'a';
                if(curr.eow){
                    if(i+1==n)return true;
                    if(!visit[i+1]){
                        que.add(i+1);
                        visit[i+1]=true;
                    }
                }
            }
        }
        return false;
    }
}
/*
 Step 1: Insert words into Trie
Insert "leet":
Create nodes for: 'l' → 'e' → 'e' → 't'
Mark 't' as eow = true
Insert "code":
Create nodes for: 'c' → 'o' → 'd' → 'e'
Mark 'e' as eow = true
 root
├── l → e → e → t (eow)
└── c → o → d → e (eow)

Step 2: BFS traversal using Queue
visit[]: [true, false, false, ..., false] (size = s.length()+1)
queue: [0] — we start from index 0


BFS Loop:
📍 Round 1: start = 0
curr = root

Traverse from s[0] = 'l':

'l' exists → move to 'e'

'e' exists → move to second 'e'

second 'e' exists → move to 't'

't' is eow == true → we found "leet" (0 to 3)

i+1 = 4 → not end of string → visit[4] = true → queue.add(4)

Queue becomes: [4]
visit[]: [true, false, false, false, true, false, false, false, false]

📍 Round 2: start = 4
curr = root

Traverse from s[4] = 'c':

'c' exists → move to 'o'

'o' exists → move to 'd'

'd' exists → move to 'e'

'e' is eow == true → we found "code" (4 to 7)

i+1 = 8 == s.length → 🎉 return true



 */