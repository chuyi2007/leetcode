public class Solution {
    public int[] buildFalureFunction(char[] needle) {
        int[] f = new int[needle.length + 1];
        for (int i = 2; i < needle.length; ++i) {
            int j = f[i - 1];
            do {
                if (needle[i - 1] == needle[j]) {
                    f[i] = j + 1;
                    break;
                } else {
                    j = f[j];
                }
            } while (f[j] != 0);
        }
        return f;
    }
    
    // KMP method
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] f = buildFalureFunction(needle.toCharArray());
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                ++i;
                ++j;
            } else if (j > 0) {
                j = f[j];
            } else {
                ++i;
            }
        }
        return -1;
    }
}

//If use startWith, it's easy
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle.length() == 0) {
            return haystack;
        }
        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.substring(i).startsWith(needle)) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
