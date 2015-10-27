public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!sMap.containsKey(sChar) && !tMap.containsKey(tChar)) {
                sMap.put(sChar, i);
                tMap.put(tChar, i);
            } else if (tMap.containsKey(tChar) && sMap.containsKey(sChar)) {
                if (!Objects.equals(sMap.get(sChar), tMap.get(tChar)))
                    return false;
                else {
                    sMap.put(sChar, i);
                    tMap.put(tChar, i);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
