public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                return s.length() - 1 - i;
            }
        }
        return s.length();
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            --end;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            --start;
        }
        return end - start;
    }
}
