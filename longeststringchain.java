import java.util.HashMap;

public class longeststringchain {
    public int longestStringChain(String words[]) {

        int n=words.length();
        HashMap<Stirng,Integer>dp=new HashMap<>();
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int maxlen=1;
        for(String word:words){
            int bst=1;
            for(int i=0;i<word.length();i++){
                String prev=word.substring(0,i)+word.substrig(i+1);
                if(dp.containsKey(prev)){
                    bst=Math.max(bst,dp.get(prev)+1);
                }
            }
            map.put(word,bst);
            maxlen=Math.max(maxlen,bst);

        }
        return maxlen;
    }

}
/**
 *  Step-by-Step Example for ["ba", "b", "a", "bca", "bda", "bdca"]:
After sorting by length: ["b", "a", "ba", "bca", "bda", "bdca"]

"b" → no predecessor → dp["b"] = 1

"a" → no predecessor → dp["a"] = 1

"ba" → try removing one char: "a", "b" → both exist → dp["ba"] = 2

"bca" → try: "ca", "ba", "bc" → only "ba" exists → dp["bca"] = 3

"bda" → try: "da", "ba", "bd" → "ba" exists → dp["bda"] = 3

"bdca" → try: "dca", "bca", "bda", "bdc" → "bca" & "bda" exist → max chain = 4

✅ Final answer: 4 (["a" → "ba" → "bda" → "bdca"])
 */