public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            List<Integer> curWords = anagrams.get(key);
            int insert = 0;
            for (int j = 0; j < curWords.size(); ++j) {
                if (smallerThan(strs[i], strs[curWords.get(j)])) {
                    insert = j;
                    break;
                } else {
                    insert = j + 1;
                }
            }
            curWords.add(insert, i);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> value: anagrams.values()) {
            List<String> tmp = new ArrayList<>();
            for (int index: value) {
                tmp.add(strs[index]);
            }
            result.add(tmp);
        }
        return result;
    }
    
    public boolean smallerThan(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); ++i) {
            if (a.charAt(i) < b.charAt(i)) {
                return true;
            } else if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
