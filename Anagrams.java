//O(N), N is the length of strs
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, ArrayList<String>> strMap 
        = new HashMap<String, ArrayList<String>>();
        
        ArrayList<String> results = new ArrayList<String>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            if(!strMap.containsKey(sorted)){
                ArrayList<String> tmpResults = new ArrayList<String>();
                tmpResults.add(str);
                strMap.put(sorted, tmpResults);
            }
            else{
                ArrayList<String> tmpResults = strMap.get(sorted);
                tmpResults.add(str);
            }
        }
        
        Iterator<String> iter = strMap.keySet().iterator();
        while(iter.hasNext()){
            ArrayList<String> tmpResult = strMap.get(iter.next());
            if(tmpResult.size() > 1)
                for(String str : tmpResult)
                    results.add(str);
        }
        return results;
    }
}