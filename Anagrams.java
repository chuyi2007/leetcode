public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = 
            new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; ++i) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for (ArrayList<String> val : map.values()) {
            if (val.size() > 1) {
                result.addAll(val);
            }
        }
        return result;
    }
}