public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = new char[26];
        char[] tChars = new char[26];
        for (int i = 0; i < s.length(); ++i) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}
