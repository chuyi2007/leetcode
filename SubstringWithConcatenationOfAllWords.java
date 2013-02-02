public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int unit = L[0].length();
        int index = 0;
        boolean[] found = new boolean[L.length];
        int start = -1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(index <= S.length() - unit){
            String w = S.substring(index, index + unit);
            if(checkExist(L, w, found)){
                if(start == -1)
                    start = index;
                
                if(foundAll(found)){
                    result.add(start);
                    index = start + 1;
                    setFalse(found);
                    start = -1;
                }
                else
                    index += unit;
            }
            else{
                if(start != -1){
                    setFalse(found);
                    index = start + 1;
                    start = -1;
                }
                else
                    index += 1;
            }
        }
        return result;
    }
    
    public void setFalse(boolean[] found){
        for(int i = 0; i < found.length; ++i)
            found[i] = false;
    }
    
    public boolean foundAll(boolean[] found){
        for(int i = 0; i < found.length; ++i)
            if(!found[i])
                return false;
        return true;
    }
    
    public boolean checkExist(String[] L, String w, boolean[] found){
        for(int i = 0; i < L.length; ++i){
            if(!found[i] && L[i].equals(w)){
                found[i] = true;
                return true;
            }
        }
        return false;
    }
}

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