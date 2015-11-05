// naive solution, TLE
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, !map.containsKey(word) ? 1 : (map.get(word) + 1));
        }
        List<Integer> res = new ArrayList<>();
        int startIndex = 0;
        int size = words[0].length();
        for (int i = 0; i < s.length() - size * words.length; ++i) {
            String word = s.substring(i, i + size);
            if (map.containsKey(word)) {
                Map<String, Integer> cur = new HashMap<>();
                cur.put(word, 1);
                for (int j = 1; j < words.length; ++j) {
                    word = s.substring(i + j * size, i + (j + 1) * size);
                    cur.put(word, !cur.containsKey(word) ? 1 : (cur.get(word) + 1));
                    if (!map.containsKey(word) || cur.get(word) > map.get(word)) {
                        break;
                    }
                }
                if (cur.equals(map)) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
