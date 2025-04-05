//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String>hs=new HashSet<>();
        String str="";
        helper(s,str,hs);
        ArrayList<String>ans=new ArrayList<>(hs);
        return ans;
        
    }
    public void helper(String s, String str, HashSet<String>hs){
        if(s.isEmpty()){
            hs.add(str);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            String rem=s.substring(0,i)+ s.substring(i+1);
            helper(rem,str+ch,hs);
        }
    }
}
/*
    
*/