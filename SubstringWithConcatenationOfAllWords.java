//O(N * k * l) N is length of S, k is length of L, l is word length in L
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = 0;
        int wordLen = L[0].length();
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(L));
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int start = 0;
        while(index <= S.length() - wordLen){
            String word = S.substring(index, index + wordLen);
            if(words.size() == L.length)
                start = index;
            if(words.contains(word)){
                words.remove(word);
                index += wordLen;
            }
            else{
                words = new ArrayList<String>(Arrays.asList(L));
                index = start + 1;
            }
            
            if(words.size() == 0){
                result.add(start);
                start = start + wordLen;
                index = start;
                words = new ArrayList<String>(Arrays.asList(L));
            }  
        }
        return result;
    }
}